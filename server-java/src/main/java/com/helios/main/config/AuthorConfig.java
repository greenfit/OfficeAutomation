package com.helios.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.helios.main.interceptor.AuthorInterceptor;

/**
 * 访问权限的配置项
 */
@Configuration
public class AuthorConfig extends WebMvcConfigurerAdapter {
	
	/**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/login.html", "/login.json");
    }
}
