package com.userProfile.Config;

import com.userProfile.Filter.JwtTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean jwtFavouriteFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new JwtTokenFilter());
        filter.addUrlPatterns("/newsWave/getUserById/*");
        filter.addUrlPatterns("/newsWave/deleteUser/*");
        filter.addUrlPatterns("/newsWave/updateDetails/*");

        return filter;
    }
}
