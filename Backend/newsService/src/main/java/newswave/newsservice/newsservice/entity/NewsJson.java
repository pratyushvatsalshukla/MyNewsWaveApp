package newswave.newsservice.newsservice.entity;

import java.util.List;

public class NewsJson {

    List<Articles> articles ;

    public NewsJson(List<Articles> articles) {
        this.articles = articles;
    }

    public NewsJson() {
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }
}
