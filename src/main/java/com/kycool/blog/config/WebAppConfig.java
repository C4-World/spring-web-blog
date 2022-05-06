package com.kycool.blog.config;


import com.kycool.blog.response.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * 添加自定义拦截器
     */
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     System.out.println("---------000000000000----------");
    //     registry.addInterceptor(new ResponseResultInterceptor());
    // }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResponseResultInterceptor());
    }
}
