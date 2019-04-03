package com.spg.admin.web.interceptor;

import com.spg.admin.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        if (SessionUtil.getSession().getAttribute("admin") == null) {
            response.sendRedirect("/login.html");
            return false;
        }else {
            return true;
        }
    }


}
