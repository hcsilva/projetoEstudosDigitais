package br.com.digitaLife.cardapioDigital.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Getter
@Setter
@Log4j2
@Configuration
@ConfigurationProperties("spring.datasource")
public class DataBaseConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("DESENVOLVIMENTO")
    @Bean
    public String dataBaseConnection(){
        log.info("DataBase Connection DESENVOLVIMENTO");
        log.info(driverClassName);
        log.info(url);

        return "Db Connection";
    }

    @Profile("PRODUCAO")
    @Bean
    public String dataBaseProductionConnection(){
        log.info("DataBase Connection PRODUCAO");
        log.info(driverClassName);
        log.info(url);

        return "Db Connection";
    }
}
