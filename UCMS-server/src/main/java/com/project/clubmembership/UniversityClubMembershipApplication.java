package com.project.clubmembership;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@SecurityScheme(
//		name = "Bearer Authentication",
//		type = SecuritySchemeType.HTTP,
//		bearerFormat = "JWT",
//		scheme = "bearer")
public class UniversityClubMembershipApplication {


	public static void main(String[] args) {
		SpringApplication.run(UniversityClubMembershipApplication.class, args);
	}
//	@Bean
//	public OpenAPI customizeOpenAPI() {
//		final String securitySchemeName = "bearerAuth";
//		return new OpenAPI()
//				.addSecurityItem(new SecurityRequirement()
//						.addList(securitySchemeName))
//				.components(new Components()
//						.addSecuritySchemes(securitySchemeName, new io.swagger.v3.oas.models.security.SecurityScheme()
//								.name(securitySchemeName)
//								.type(Type.HTTP)
//								.scheme("bearer")
//								.bearerFormat("JWT")));
//	}


}
