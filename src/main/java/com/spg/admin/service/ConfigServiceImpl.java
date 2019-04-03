package com.spg.admin.service;

import com.spg.admin.dao.ConfigMapper;
import com.spg.admin.domain.Config;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigMapper configMapper;

    @Override
    public List<Config> findDomainNamesCanUse() {
        return configMapper.findDomainNamesCanUse();
    }
}
