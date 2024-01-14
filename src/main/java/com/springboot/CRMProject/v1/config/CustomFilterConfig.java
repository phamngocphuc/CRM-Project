package com.springboot.CRMProject.v1.config;

import com.springboot.CRMProject.v1.filter.AuthenticationFilter;
import com.springboot.CRMProject.v1.filter.CustomLoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFilterConfig{

	@Bean
	public FilterRegistrationBean<CustomLoginFilter> filterConfig(){

		FilterRegistrationBean<CustomLoginFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new CustomLoginFilter());
		registrationBean.addUrlPatterns("/login");
		registrationBean.setOrder(1);

		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<AuthenticationFilter> authenFilterConfig(){

		FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new AuthenticationFilter());
		registrationBean.addUrlPatterns("/role/add");
		registrationBean.setOrder(2);

		return registrationBean;
	}

	/*
	* 1) Neu user da dang nhap roi thi cong can dang nhap lai (ke ca khi truy cap link /logn -> chuyen ve index
	*
	* 2) Hay tao tinh nang phan quyen cho he thong CRM
	* ADMIN: them, xoa, sua ROLE
	*
	* */
}
