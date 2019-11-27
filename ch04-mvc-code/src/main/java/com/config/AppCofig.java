package com.config;

import com.interceptro.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 配置类
 */
@Configuration
@ComponentScan("com.controller") //等价于 xml配置方法中的 <context:component-scan base-package="">
@EnableWebMvc  //等价于 xml配置方法中的 <mvc:annotation-driven>
public class AppCofig implements WebMvcConfigurer {

    /**
     * 视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final MyInterceptor myInterceptor = new MyInterceptor();
        final InterceptorRegistration interceptorRegistration = registry.addInterceptor(myInterceptor);
        interceptorRegistration.addPathPatterns("/**");
    }
}
