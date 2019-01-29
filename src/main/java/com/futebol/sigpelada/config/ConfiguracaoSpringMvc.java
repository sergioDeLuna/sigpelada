package com.futebol.sigpelada.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfiguracaoSpringMvc {
 
    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        Map<String, Object> scopes = new HashMap<>();
        scopes.put("view", new ViewScope());

        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.setScopes(scopes);

        return customScopeConfigurer;
    }
  
}
