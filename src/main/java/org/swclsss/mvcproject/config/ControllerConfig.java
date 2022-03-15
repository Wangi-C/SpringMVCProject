package org.swclsss.mvcproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.swclsss.mvcproject.chap09.HelloController;
import org.swclsss.mvcproject.chap11.RegistController;
import org.swclsss.mvcproject.chap11.RegisterService;

@Configuration
public class ControllerConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public RegistController registController() {
        return new RegistController();
    }

    @Bean
    public RegisterService registerService() {
        return new RegisterService();
    }
}
