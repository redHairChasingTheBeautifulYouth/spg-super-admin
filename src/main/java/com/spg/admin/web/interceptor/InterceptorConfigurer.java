package com.spg.admin.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Auther: trevor
 * @Date: 2019\3\28 0028 01:03
 * @Description:
 */
@Component
public class InterceptorConfigurer implements WebMvcConfigurer{

    @Resource
    private CORSInterceptor corsInterceptor;

    @Resource
    private LoginInterceptor loginInterceptor;

    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
//        //第一个方法设置访问路径前缀，第二个方法设置资源路径
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor)
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/**")
                //排除swagger
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/swagger-ui.html/**")
                //排除测试登陆
                .excludePathPatterns("/api/testLogin/login")
                //排除错误页面
                .excludePathPatterns("/error.html")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/file/**")
                //排除超级管理员登陆
                .excludePathPatterns("/admin/login");
    }

}
