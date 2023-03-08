package com.cloud.badminton.framework.config;

import com.cloud.badminton.framework.common.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 21:46
 */
@Configuration
public class XssConfiguration {


    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        /*设置请求*/
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        /*设置过滤器*/
        registration.setFilter(new XssFilter());
        /*设置优先级*/
        registration.setOrder(Integer.MAX_VALUE);

        /*设置初始参数*/
        //registration.setInitParameters();

        return registration;
    }
}
