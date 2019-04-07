package com.spg.admin.service;


import com.spg.admin.bo.JsonEntity;
import com.spg.admin.bo.MessageCodeEnum;
import com.spg.admin.bo.ResponseHelper;
import com.spg.admin.bo.SuperAdminLogin;
import com.spg.admin.dao.SuperAdminMapper;
import com.spg.admin.domain.Config;
import com.spg.admin.domain.Room;
import com.spg.admin.domain.SuperAdmin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author
 * @date 03/27/19 12:56
 */
@Service
public class SuperAdminServiceImpl implements SuperAdminServcie {

    @Resource
    private SuperAdminMapper superAdminMapper;

    @Resource
    private RoomService roomService;

    @Resource
    private ConfigService configService;

    @Override
    public JsonEntity<SuperAdmin> login(SuperAdminLogin superAdminLogin) {
        SuperAdmin admin = superAdminMapper.findByAccount(superAdminLogin.getAccount());
        if (admin == null) {
            return ResponseHelper.withErrorInstance(MessageCodeEnum.SUPER_ADMIN_LOGIN_ERROR);
        }else {
            synchronized (this) {
                if (admin.getErrorNum() > 100L) {
                    return ResponseHelper.withErrorInstance(MessageCodeEnum.ERROR_NUM_MAX);
                }
                if (!Objects.equals(admin.getPassword() ,superAdminLogin.getPassward())) {
                    superAdminMapper.updateLoginErrorNum(admin.getId() ,admin.getErrorNum() + 1L);
                    return ResponseHelper.withErrorInstance(MessageCodeEnum.SUPER_ADMIN_LOGIN_ERROR);
                }else {
                    return ResponseHelper.createInstance(admin ,MessageCodeEnum.LOGIN_SUCCESS);
                }
            }
        }
    }

    @Override
    public JsonEntity<String> createRoom(){
        Room room = new Room();
        room.setRoomName("小私群");
        roomService.insertOne(room);
        List<Config> domainNames = configService.findDomainNamesCanUse();
        if (domainNames.isEmpty()) {
            return ResponseHelper.withErrorInstance(MessageCodeEnum.NO_DOMAIN_NAMES);
        }
        return ResponseHelper.createInstance(domainNames.get(0).getDomainName() + "/wechart?room=" + room.getId(),MessageCodeEnum.CREATE_SUCCESS);
    }
}
