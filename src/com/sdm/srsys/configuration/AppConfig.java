package com.sdm.srsys.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.sdm.srsys.interceptor.AuthInterceptor;
import com.sdm.srsys.interceptor.ExecuteTimeInterceptor;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sdm.srsys")
public class AppConfig extends WebMvcConfigurerAdapter {
     
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	// Here is to define location of jsp files and also type of file to read from
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// Here to specify any folder for resources of javascripts, css style or images 
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
    	// code and interceptor here to intercep any request done from each screen to back end
    	// here also to specify any path that is valid for the app to read
	    registry.addInterceptor(new AuthInterceptor())
	    			.addPathPatterns("/student*")
	    			.addPathPatterns("/other*");
	    registry.addInterceptor(new ExecuteTimeInterceptor());
	}

    @Bean
    public MessageSource messageSource() {
    	// Here to defind the usage of message bundle where stored any wording for the screen or errors
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    

}
