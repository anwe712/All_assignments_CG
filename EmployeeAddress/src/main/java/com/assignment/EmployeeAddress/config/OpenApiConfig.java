package com.assignment.EmployeeAddress.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Employee Address API",
                version = "v1",
                description = "API for managing employees and their addresses",
                contact = @Contact(name = "Employee Address"),
                license = @License(name = "Apache 2.0")
        ),
        servers = {
                @Server(url = "http://localhost:8082", description = "Local server")
        }
)
public class OpenApiConfig {
}
