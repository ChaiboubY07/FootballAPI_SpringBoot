package com.example.football_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Football API")
                                .version("1.0")
                                .description("API publique de football"))
                .servers(List.of(
                        new Server().url("https://football-api-mxbx.onrender.com").description("Render (prod)")
                ));
    }
}
