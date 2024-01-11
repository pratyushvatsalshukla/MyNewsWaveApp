package newsWave.wishlist.Config;


import newsWave.wishlist.Filter.JwtTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean jwtFavouriteFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new JwtTokenFilter());
        filter.addUrlPatterns("/wishlist/*");
        filter.addUrlPatterns("/wishlist/save");
        filter.addUrlPatterns("/wishlist/deleteWishlist/*");
        return filter;
    }
}

