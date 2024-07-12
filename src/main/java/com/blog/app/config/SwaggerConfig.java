package com.blog.app.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
		
	}

	private ApiInfo getInfo() {
	
		return new ApiInfo("Blogging Application APIs","This project is for learning purpose", "3.0", "Terms of Service", new Contact("Yash", "https://www.linkedin.com/in/yash-singh-0b694a22b/", "yashingh@gmail.com"), "License of apis", "Licence URL", Collections.emptyList());
	};
}







