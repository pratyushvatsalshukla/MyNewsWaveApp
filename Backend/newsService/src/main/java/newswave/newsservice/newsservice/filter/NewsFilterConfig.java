package newswave.newsservice.newsservice.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewsFilterConfig {

    Logger logger = LoggerFactory.getLogger(NewsFilterConfig.class);
    @Bean
    public FilterRegistrationBean jwtFavouriteFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new JwtTokenFilter());
        filter.addUrlPatterns("/newsService/*");
        return filter;
    }
}
