package com.prabathj.lc.configurations;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.prabathj.lc.formatters.CreduCardFormatter;
import com.prabathj.lc.formatters.CurrencyFormatter;
import com.prabathj.lc.formatters.MobileNumberFormatter;

@Configuration
//Enable default Java based configuration (eg.create beans for MVC project like ObjectMapper in JACKSON)
//[import the configuration  we can customise these configuration using methods are defined in WebMvcConfigurer]
@EnableWebMvc  
@ComponentScan(basePackages = {"com.prabathj.lc.controllers","com.prabathj.lc.services","com.prabathj.lc.conrolleradvices"})
@PropertySources(@PropertySource("classpath:/configurable_properties/configuration_info.properties"))
public class LCWebConfiguration implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;

	@Bean
	public ViewResolver getViewR(){
		InternalResourceViewResolver obj=new InternalResourceViewResolver();
		obj.setPrefix("/WEB-INF/jsp-pages/");
		obj.setSuffix(".jsp");
		return obj;
	}

	
	//Register formatters
	public void addFormatters(FormatterRegistry registry) {

		registry.addFormatter(new MobileNumberFormatter());	
		registry.addFormatter(new CreduCardFormatter());
		registry.addFormatter(new CurrencyFormatter());

	}	
	
	////Add Resource bundle to Validator
	
	@Bean
	public MessageSource messageSource(){
		//Look at the Class path implicitly No need to add 'classpath:' or '.properties'
		ResourceBundleMessageSource resourceB=new ResourceBundleMessageSource();
		resourceB.setBasename("/validator_messages/validmessage");
		
		return resourceB;
	}

	@Bean
	public LocalValidatorFactoryBean validator(){
		
		LocalValidatorFactoryBean validatorFactory=new LocalValidatorFactoryBean();
	
		//inter-bean dependency, where following line inject the MessageSource bean
		
		validatorFactory.setValidationMessageSource(messageSource());
		return  validatorFactory;
	}
	
	
	public Validator getValidator() {

		return validator();
	}
	
	////Add Resource bundle to Validator
	
	//////COnfigure Mail Server/////////
	@Bean
	public JavaMailSender getJavamailSenderBean(){
		
		JavaMailSenderImpl jmailSender=new JavaMailSenderImpl();
		jmailSender.setHost(env.getProperty("mail.Host"));
		jmailSender.setPort(Integer.parseInt(env.getProperty("mail.Port")));
		jmailSender.setUsername(env.getProperty("mail.Username"));
		jmailSender.setPassword(env.getProperty("mail.password"));
		
		jmailSender.setJavaMailProperties(getMailExtraProperty());
		return jmailSender;
	}


	private Properties getMailExtraProperty() {
		Properties mailProperties=new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return mailProperties;
	}
	//////COnfigure Mail Server/////////
}
