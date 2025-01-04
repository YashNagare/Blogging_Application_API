package com.cypher.blog_app_apis.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig(){
        return new OpenAPI().info(new Info().title("Blogging Application APIs")
                                .description("By Yash Nagare❤\uFE0F")
                                .version("1.0")
                                .contact(new Contact()
                                        .name("Yash Nagare")
                                        .email("yashpnagare@gmail.com")
                                        .url("https://www.linkedin.com/in/yashnagare/")))

                            .components(new Components().addSecuritySchemes("bearerAuth",
                                    new SecurityScheme()
                                            .name("Authorization")
                                            .type(SecurityScheme.Type.HTTP)
                                            .scheme("bearer")
                                            .in(SecurityScheme.In.HEADER)
                                            .bearerFormat("JWT")))
                            .addSecurityItem(new SecurityRequirement().addList("bearerAuth")
        );
    }
}
