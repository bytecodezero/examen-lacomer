package com.odma.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;



@Configuration
public class SwaggerConfig {


	@Bean
	public OpenAPI apiInfoMetaData() {
		return new OpenAPI().info(new Info()
				.title("Documentación de API")
				.description("En este documento se describe el propósito del API")
				.version("1.0.0")
				.contact(new Contact()
						.name("dev-odma")
						.url("https://github.com")
						.email("oscard.munozabarca@outlook.com"))
				.license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0")
						.url("http://www.apache.org/licenses/LICENSE-2.0.html")));
	}

}
