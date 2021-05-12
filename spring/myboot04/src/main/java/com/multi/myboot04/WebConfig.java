package com.multi.myboot04;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //현재클래스 설정 모든 결과 xml 파일 <bean
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///c:/upload/");
        registry.addResourceHandler("/faceimages/**")
        		.addResourceLocations("file:///C:/Users/정동현/Desktop/images/");
    }
}


