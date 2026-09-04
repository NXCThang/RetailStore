package com.rs.retailstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI retailStoreOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RetailStore API")
                        .description("RetailStore API documentation")
                        .version("1.0.0"));
    }
}
