package newswave.newsservice.newsservice.controller;

import newswave.newsservice.newsservice.service.NewsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/newsService/")
public class NewsController {

    @Autowired
    NewsServiceImpl newsService ;
    Logger logger = LoggerFactory.getLogger(NewsController.class);

    public NewsController(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @PostMapping("")
    public ResponseEntity<?> getLatestHeadlines(){
        logger.info("Entered Into News Service -Controller- getLatestHeadlines") ;

        return new ResponseEntity<>(newsService.getLatestHeadlines(),HttpStatus.OK) ;
    }

    @GetMapping("/{subject}")
    public ResponseEntity<?> getListCommonNewsArticles(@PathVariable String subject) throws IOException {
        logger.info("Entered Into News Service -Controller- getListCommonNewsArticles") ;

        return new ResponseEntity<>(newsService.getListCommonNewsArticles(subject), HttpStatus.OK) ;

    }

}
