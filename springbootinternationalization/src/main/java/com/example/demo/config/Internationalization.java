package com.example.demo.config;

import java.util.Locale;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Component
public class Internationalization implements WebMvcConfigurer{
	
	
	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver slr=new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		System.out.println(slr);
		return slr;
		
	}
	
	@Bean
	public LocaleChangeInterceptor changeInterceptor()
	{
		LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		System.out.println(localeChangeInterceptor);
		return localeChangeInterceptor;
		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(changeInterceptor());
	}

	
}
