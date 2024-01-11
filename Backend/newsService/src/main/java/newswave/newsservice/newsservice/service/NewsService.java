package newswave.newsservice.newsservice.service;

import newswave.newsservice.newsservice.entity.NewsJson;
import org.springframework.http.HttpEntity;

public interface NewsService {

    NewsJson getListCommonNewsArticles(String search);

    HttpEntity<?> getEntity();

//    NewsJson getFilteredNewsArticles(Filters filters);

}