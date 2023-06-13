package com.test.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

//4.定义servlet容器的启动类，加载spirng的配置
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    //加载springmvc容器配置
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }
    //设置请求归属spinrgmvc处理
    protected String[] getServletMappings() {
        //所有请求贵springmvc处理
        return new String[]{"/"};
    }
    //加载spring容器配置
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    //乱码处理：过滤器

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}
