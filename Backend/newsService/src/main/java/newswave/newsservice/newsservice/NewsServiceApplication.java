package newswave.newsservice.newsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NewsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsServiceApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean getBean(){
//		FilterRegistrationBean bean = new FilterRegistrationBean();
//		bean.setFilter(new NewsFilter());
//		bean.addUrlPatterns("/newsService/*");
//		return bean;
//	}

}
