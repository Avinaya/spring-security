package com.springboot.blog.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private final static String MODULE_NAME = "Partner App";
    private final static String SCHEME_NAME = "JWT_Token";
    private final static String BEARER = "Bearer";
    private final static String JWT = "JWT";
    private final static String API_VERSION = "1.0";

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME))
                .components(
                        new Components()
                                .addSecuritySchemes(SCHEME_NAME,
                                        new SecurityScheme()
                                                .name(SCHEME_NAME)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme(BEARER)
                                                .bearerFormat(JWT)
                                )
                ).info(new Info().title(MODULE_NAME).version(API_VERSION));
    }

}
