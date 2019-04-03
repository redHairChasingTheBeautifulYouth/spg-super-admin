package com.spg.admin.web.interceptor;

import com.spg.commom.WebKeys;
import com.spg.service.UserService;
import com.spg.util.SessionUtil;
import com.spg.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * @Auther: trevor
 * @Date: 2019\3\28 0028 01:22
 * @Description:
 */
@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {




    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Sess
        if ()
    }


}
