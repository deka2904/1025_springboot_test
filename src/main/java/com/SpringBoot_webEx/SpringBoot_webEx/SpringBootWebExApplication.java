package com.SpringBoot_webEx.SpringBoot_webEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.Charset;

@SpringBootApplication
public class SpringBootWebExApplication {
	public static void main(String[] args) {
		System.setProperty("server.port", "8088");
		SpringApplication.run(SpringBootWebExApplication.class, args);
	}
}
