package org.swclsss.mvcproject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;
import org.swclsss.mvcproject.chap11.RegisterRequestValidator;
import org.swclsss.mvcproject.logInOut.LoginCheckInterceptor;

import java.util.List;

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
        registry.addViewController("/topics/list").setViewName("topicForm/topicList");
    }

    @Override
    public Validator getValidator() {
        return new RegisterRequestValidator();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .addPathPatterns("/topics/**")
                .excludePathPatterns("/topics/list/**");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                .json()
                .simpleDateFormat("yyyy-MM-dd-HH:mm:ss")
                .build();
        converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("message.label");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}