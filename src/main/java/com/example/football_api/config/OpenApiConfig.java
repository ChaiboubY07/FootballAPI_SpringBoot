package com.example.football_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.security.*;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Football API",
        version = "1.0",
        description = "API REST pour gérer des matchs, joueurs, équipes et compétitions de football",
        contact = @Contact(
            name = "CHAIBOUB Youssef",
            email = "ch.youssef.contact@gmail.com"
        )
    ),
    servers = {
        @Server(url = "https://football-api-mxbx.onrender.com", description = "Render (prod)")
    },
    security = @SecurityRequirement(name = "bearerAuth")
)

@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
public class OpenApiConfig {
}
