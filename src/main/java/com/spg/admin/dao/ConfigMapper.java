package com.spg.admin.dao;

import com.spg.admin.domain.Config;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConfigMapper {

    List<Config> findDomainNamesCanUse();
}
