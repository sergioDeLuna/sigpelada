package com.futebol.sigpelada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

/**
 * Classe de Configuração
 * @author sergioluna
 *
 */
@Configuration
public class ConfiguracaoSpringMvc implements WebMvcConfigurer {
	/**
	 * Lidando com Thymeleaf nas páginas web
	 * @param resolver
	 * @return
	 */
	@Bean
	public SpringTemplateEngine templateEngine
	   (SpringResourceTemplateResolver resolver) {
	   SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	   templateEngine.setTemplateResolver(resolver);
	   return templateEngine;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addViewController("/").setViewName("home");
	   registry.addViewController("/home").setViewName("home");
	}
  
}
