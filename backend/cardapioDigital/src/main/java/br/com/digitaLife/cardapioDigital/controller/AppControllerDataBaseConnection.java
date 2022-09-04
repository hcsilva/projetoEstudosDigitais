package br.com.digitaLife.cardapioDigital.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControllerDataBaseConnection {

    @Value("${app.message}")
    private String appMessage;

    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbEnviromentVariable;

    @GetMapping("/")
    public String getAppMessage() {
        return appMessage;
    }

    @GetMapping("/envVariable")
    public String getEnviromentVariable() {
        return "A seguinte variável de ambiente foi passada: " + dbEnviromentVariable;
    }

}
