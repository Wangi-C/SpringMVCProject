package org.swclsss.mvcproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;
import org.swclsss.mvcproject.chap11.RegisterRequestValidator;

@Configuration
@EnableWebMvc
public class MVCConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/",".jsp");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main").setViewName("register/main");
        registry.addViewController("/signIn").setViewName("login/loginForm");
    }

    @Override
    public Validator getValidator() {
        return new RegisterRequestValidator();
    }
}