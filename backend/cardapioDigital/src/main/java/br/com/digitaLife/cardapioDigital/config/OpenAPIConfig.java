package br.com.digitaLife.cardapioDigital.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    public static final String TITLE = "Cardápio Digital";
    public static final String DESCRIPTION = "BackEnd projeto Cardápio Digital";
    public static final String VERSION = "v0.0.1";

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(TITLE)
                        .description(DESCRIPTION)
                        .version(VERSION)
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }

}