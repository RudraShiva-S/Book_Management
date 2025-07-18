package com.bookmanager.Config;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI bookManagerOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Book Manager API")
                            .description("A simple CRUD API for managing books")
                            .version("1.0"));
        }
    }


