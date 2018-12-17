package net.gitschthaler.zipkin.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean // needed so zipkin can inject
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}