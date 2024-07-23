package com.hotel.configurataion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class BeanConfiguration {
	
	@Bean
	 ModelAndView getMAV() {
		return  new ModelAndView();
	}
}
