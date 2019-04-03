package com.spg.admin.service;


import com.spg.admin.bo.JsonEntity;
import com.spg.admin.bo.SuperAdminLogin;
import com.spg.admin.domain.SuperAdmin;

/**
 * @author trevor
 * @date 03/27/19 12:55
 */
public interface SuperAdminServcie {

    /**
     * 登陆
     * @param superAdminLogin
     * @return
     */
    JsonEntity<SuperAdmin> login(SuperAdminLogin superAdminLogin);

    /**
     * 创建房间
     * @return
     */
    JsonEntity<String> createRoom();
}
