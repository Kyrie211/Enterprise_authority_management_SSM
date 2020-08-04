package com.krismile.eam_ssm.service;

import com.krismile.eam_ssm.domain.SysLog;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-08-02 16:57
 */
public interface ISysLogService {
    void save(SysLog log) throws Exception;

    List<SysLog> findAll() throws Exception;
}
