package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	Logger logger = LoggerFactory.getLogger(MvcConfig.class);
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		logger.info("called configureDefaultServletHandling(DefaultServletHandlerConfigurer):void");
		configurer.enable();
	}
	public void configureViewResolvers(ViewResolverRegistry registry) {
		logger.info("called configureViewResolvers(ViewResolverRegistry):void");
		registry.jsp("/WEB-INF/jsp/",".jsp");
	}
}
