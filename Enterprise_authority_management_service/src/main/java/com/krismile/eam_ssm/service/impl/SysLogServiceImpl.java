package com.krismile.eam_ssm.service.impl;

import com.krismile.eam_ssm.dao.ISysLogDao;
import com.krismile.eam_ssm.domain.SysLog;
import com.krismile.eam_ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-08-02 16:57
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

}
