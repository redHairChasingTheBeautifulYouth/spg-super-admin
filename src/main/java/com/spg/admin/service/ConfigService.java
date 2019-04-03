package com.spg.admin.service;


import com.spg.admin.domain.Config;

import java.util.List;

public interface ConfigService {

    /**
     * 查询可用域名
     * @return
     */
    List<Config> findDomainNamesCanUse();
}
