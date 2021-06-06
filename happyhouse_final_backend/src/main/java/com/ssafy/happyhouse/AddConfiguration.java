package com.ssafy.happyhouse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.interceptor.JwtInterceptor;

@Configuration
public class AddConfiguration implements WebMvcConfigurer{
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new ConfirmInterceptor())
//		.excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**");
//		//제외 경로경로 지정해줘야함
//	}
}
