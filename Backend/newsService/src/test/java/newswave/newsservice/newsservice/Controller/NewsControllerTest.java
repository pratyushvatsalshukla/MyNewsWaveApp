//package newswave.newsservice.newsservice.Controller;
//
//import newswave.newsservice.newsservice.controller.NewsController;
//import newswave.newsservice.newsservice.entity.Articles;
//import newswave.newsservice.newsservice.entity.NewsJson;
//import newswave.newsservice.newsservice.service.NewsServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class NewsControllerTest {
//
//    @Mock
//    private NewsServiceImpl newsService;
//
//    @InjectMocks
//    private NewsController newsController;
//
//    @Test
//    void testGetLatestHeadlines() {
//        // Mocking service behavior
//        when(newsService.getLatestHeadlines()).thenReturn(new NewsJson(Arrays.asList(new Articles("Title 2","dummyAuthor2", "bababc.co.in","pqrsxyz.com/abc.jpg", "Content 2", "abcdefghij"))));
//
//        // Calling the controller method
//        ResponseEntity<?> responseEntity = newsController.getLatestHeadlines();
//
//        // Verifying service method calls
//        verify(newsService, times(1)).getLatestHeadlines();
//
//        // Assertions
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//        assertTrue(responseEntity.getBody() instanceof NewsJson);
//
//        NewsJson newsJson = (NewsJson) responseEntity.getBody();
//        assertNotNull(newsJson.getArticles());
//        assertEquals(1, newsJson.getArticles().size());
//    }
//
//    @Test
//    void testGetListCommonNewsArticles() throws IOException {
//        // Mocking data
//        String subject = "mockedSubject";
//        List<Articles> mockedArticles = Arrays.asList(
//                new NewsJson(Arrays.asList(new Articles("Title 2","dummyAuthor2", "bababc.co.in","pqrsxyz.com/abc.jpg", "Content 2", "abcdefghij"),
//                        new Articles("Title 2","dummyAuthor2", "bababc.co.in","pqrsxyz.com/abc.jpg", "Content 2", "abcdefghij")))) ;
//
//        // Mocking service behavior
//        when(newsService.getListCommonNewsArticles(subject)).thenReturn(mockedArticles);
//
//        // Calling the controller method
//        ResponseEntity<?> responseEntity = newsController.getListCommonNewsArticles(subject);
//
//        // Verifying service method calls
//        verify(newsService, times(1)).getListCommonNewsArticles(subject);
//
//        // Assertions
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//        assertTrue(responseEntity.getBody() instanceof NewsJson);
//
//        NewsJson newsJson = (NewsJson) responseEntity.getBody();
//        assertNotNull(newsJson.getArticles());
//        assertEquals(2, newsJson.getArticles().size());
//    }
//}
