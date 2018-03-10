package com.project.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Configuration
@ComponentScan({ "com.project" })
@EnableWebMvc

public class Configurations extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewPicking() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		return vr;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(stringHttpConverter());
		converters.add(converter());
	}

	@Bean
	public StringHttpMessageConverter stringHttpConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		return converter;
	}

	private ObjectMapper objectMapper() {
		Jackson2ObjectMapperFactoryBean bean = new Jackson2ObjectMapperFactoryBean();
		bean.setIndentOutput(true);
		bean.setSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		bean.afterPropertiesSet();
		ObjectMapper objectMapper = bean.getObject();
		objectMapper.registerModule(new JodaModule());
		return objectMapper;
	}

	@Bean
	public MappingJackson2HttpMessageConverter converter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper mapper = objectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		converter.setObjectMapper(mapper);
		return converter;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/assets/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/assets/js/").setCachePeriod(31556926);
		registry.addResourceHandler("/css/**").addResourceLocations("/assets/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/fonts/**").addResourceLocations("/assets/font-awesome-4.7.0/fonts/")
				.setCachePeriod(31556926);

	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}