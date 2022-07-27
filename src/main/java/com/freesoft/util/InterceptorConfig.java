package com.freesoft.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhouwei
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new com.freesoft.util.JwtInterceptor())
                // 拦截的请求 /service/**   表示拦截service下所有
                .addPathPatterns("/**")
                // 不拦截的请求  如登录接口
                .excludePathPatterns("/system/login");
    }
}
