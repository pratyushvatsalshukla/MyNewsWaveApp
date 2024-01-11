package newswave.newsservice.newsservice.service;
import newswave.newsservice.newsservice.entity.NewsJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsServiceImpl {

    Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    private static final String API_KEY = "dB7lb07tMtBhC2QVan86tUJ1ptNfslClxLNHkNuMhug";

    private static final String API_URL_BY_TOPIC = "https://api.newscatcherapi.com/v2/search?q=";
//    private static final String getxRapidApiHost = "news67.p.rapidapi.com" ;

    private static final String API_URL_HEADLINES = "https://api.newscatcherapi.com/v2/latest_headlines?lang=en";

    private final RestTemplate restTemplate ;

    public NewsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NewsJson getLatestHeadlines() {

        return restTemplate.exchange(API_URL_HEADLINES, HttpMethod.GET, getEntity(), NewsJson.class).getBody();

    }

    public NewsJson getListCommonNewsArticles(String search) {

       String final_Url = API_URL_BY_TOPIC + search;
        logger.info("Setting final URl For API Calling...") ;
        NewsJson response= restTemplate.exchange(final_Url, HttpMethod.GET,getEntity(),NewsJson.class).getBody();
        return response ;
}

    public HttpEntity<?> getEntity() {
        HttpHeaders headers = new HttpHeaders() ;
        logger.warn("Setting Headers For API Calling...") ;
        headers.set("x-api-key", API_KEY);
        headers.set("ACCEPT",MediaType.APPLICATION_JSON_VALUE) ;
        logger.info("Finished Setting Headers For API Calling Successfully...") ;
        return new HttpEntity<>(headers) ;
    }

}