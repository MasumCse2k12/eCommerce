package com.mr.ecommerce.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableJpaAuditing
public class ApplicationConfig {

    @Bean
    public OpenAPI mrOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("E-commerce API"))
                .externalDocs(new ExternalDocumentation());
    }
}
