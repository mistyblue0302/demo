package com.example.demo.domain.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration : 스프링 빈으로 등록하기 위한 애노테이션
 * WebMvcConfigurer 인터페이스는 스프링의 기본 mvc 구성을 확장 및 수정할 수 있는 애노테이션으로
 * 인터셉터 설정, CORS, 메세지 컨버터 설정을 할 수 있다.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("*");
    }
}
