package com.spg.admin.domain;

import lombok.Data;

@Data
public class Config {

    private Long id;

    /**
     * 域名
     */
    private String domainName;
}
