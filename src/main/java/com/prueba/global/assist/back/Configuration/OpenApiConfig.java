package com.prueba.global.assist.back.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info= @Info(
                contact = @Contact(
                        name = "Ignacio Barolo",
                        email = "baroloignacio@gmail.com"
                ),
                description = "Open API Documentation for API Backend",
                title = "Test of Global Assist",
                version = "1.0"
        ),
        servers = {@Server (description = "Local ENV",
                url = "http://localhost:8080")}

)
public class OpenApiConfig {
}
