package com.practica.devops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {
	 
		@Bean
	    public Docket documentation() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(metadata());
	    }

	    private ApiInfo metadata() {
	        return new ApiInfoBuilder()
	                .title("API Practica DevOps Pragma")
	                .description("Documentación de interacción con el proyecto práctica DevOps Pragma - Cali")
	                .version("1.0")
	                .contact(new Contact("Anderson Cabezas Arboleda", "","anderson.cabezas@pragma.com.co"))
	                .build();
	    }
}
