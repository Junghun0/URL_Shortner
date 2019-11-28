package com.junghoon.spring.urlshortner.config;

import com.junghoon.spring.urlshortner.filter.CORSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean createCORSFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CORSFilter());
        return filterRegistrationBean;
    }
}
