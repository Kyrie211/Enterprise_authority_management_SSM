package com.krismile.eam_ssm.controller;

import com.krismile.eam_ssm.domain.SysLog;
import com.krismile.eam_ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author krismile
 * @Create 2020-08-02 16:46
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private ISysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

    private Date startTime; // 访问时间
    private Class executionClass;// 访问的类
    private Method executionMethod; // 访问的方法

    //前置通知
    @Before("execution(* com.krismile.eam_ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        startTime = new Date();
        executionClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        if(methodArgs==null || methodArgs.length==0) {
            executionMethod = executionClass.getMethod(methodName);
        } else{
            Class[] args = new Class[methodArgs.length];
            for (int i = 0; i < args.length; i++) {
                args[i] = methodArgs[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName, args);
        }
    }

    // 主要获取日志中其它信息，时长、ip、url...
    @After("execution(* com.krismile.eam_ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        if(executionClass!=null && executionClass != SysLogController.class) {
            RequestMapping classAnnotation = (RequestMapping)
                    executionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null && executionMethod != null) {
                // 获取方法上的@RequestMapping对象
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String url = "";
                    // 它的值应该是类上的@RequestMapping的value+方法上的@RequestMapping的value
                    url = classAnnotation.value()[0] + methodAnnotation.value()[0];
                    SysLog sysLog = new SysLog();
                    // 获取访问时长
                    Long executionTime = new Date().getTime() - startTime.getTime();
                    // 将sysLog对象属性封装
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);
                    // 获取ip
                    String ip = request.getRemoteAddr();
                    sysLog.setIp(ip);
                    // 可以通过securityContext获取，也可以从request.getSession中获取
                    SecurityContext context = SecurityContextHolder.getContext();
                    String username = ((User)
                            (context.getAuthentication().getPrincipal())).getUsername();
                    sysLog.setUsername(username);
                    sysLog.setMethod("[类名]" + executionClass.getName() + "[方法名]" +
                            executionMethod.getName());
                    sysLog.setVisitTime(startTime);
                    // 调用Service，调用dao将sysLog insert数据库
                    sysLogService.save(sysLog);
                }
            }
        }
    }

}
