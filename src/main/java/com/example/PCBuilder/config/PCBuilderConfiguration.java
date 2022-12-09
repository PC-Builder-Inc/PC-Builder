package com.example.PCBuilder.config;

import com.example.PCBuilder.service.MessageService;
import com.example.PCBuilder.service.impl.MessageServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class PCBuilderConfiguration {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
        bean.setBasenames("classpath:messages");
        bean.setUseCodeAsDefaultMessage(true);
        bean.setDefaultEncoding("UTF-8");
        return bean;
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor() {
        return new MessageSourceAccessor(messageSource());
    }

    @Bean
    public MessageService messageService(MessageSourceAccessor accessor) {
        return new MessageServiceImpl(accessor);
    }

}
