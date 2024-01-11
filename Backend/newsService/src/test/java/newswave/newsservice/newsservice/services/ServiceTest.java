//package newswave.newsservice.newsservice.services;
//
//import newswave.newsservice.newsservice.entity.NewsJson;
//import newswave.newsservice.newsservice.service.NewsServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.*;
//
//class NewsServiceImplTest {
//    private static final String API_KEY = "dB7lb07tMtBhC2QVan86tUJ1ptNfslClxLNHkNuMhug";
//
//    private static final String API_URL_BY_TOPIC = "https://api.newscatcherapi.com/v2/search?q=";
////    private static final String getxRapidApiHost = "news67.p.rapidapi.com" ;
//
//    private static final String API_URL_HEADLINES = "https://api.newscatcherapi.com/v2/latest_headlines?lang=en";
//
//    @InjectMocks
//    private NewsServiceImpl newsService;
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    @Test
//    void testGetLatestHeadlines() {
//        // Mock the behavior of restTemplate.exchange for getLatestHeadlines()
//        NewsJson expectedResponse = new NewsJson(/* create a NewsJson object with test data */);
//        when(restTemplate.exchange(eq(API_URL_HEADLINES), eq(HttpMethod.GET), any(HttpEntity.class), eq(NewsJson.class)))
//                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
//
//        // Perform the test
//        NewsJson result = newsService.getLatestHeadlines();
//
//        // Verify the result
//        assertNotNull(result);
//        // Add additional assertions based on your actual data
//    }
//
//    @Test
//    void testGetListCommonNewsArticles() {
//        // Mock the behavior of restTemplate.exchange for getListCommonNewsArticles()
//        String search = "technology";
//        NewsJson expectedResponse = new NewsJson(/* create a NewsJson object with test data */);
//        String finalUrl = API_URL_BY_TOPIC + search;
//        when(restTemplate.exchange(eq(finalUrl), eq(HttpMethod.GET), any(HttpEntity.class), eq(NewsJson.class)))
//                .thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
//
//        // Perform the test
//        NewsJson result = newsService.getListCommonNewsArticles(search);
//
//        // Verify the result
//        assertNotNull(result);
//        // Add additional assertions based on your actual data
//    }
//
//    @Test
//    void testGetEntity() {
//        // Perform the test
//        HttpEntity<?> result = newsService.getEntity();
//
//        // Verify the result
//        assertNotNull(result);
//        HttpHeaders headers = result.getHeaders();
//        assertNotNull(headers);
//        assertEquals(API_KEY, headers.getFirst("x-api-key"));
//        assertEquals(MediaType.APPLICATION_JSON_VALUE, headers.getFirst("ACCEPT"));
//        // Add additional assertions based on your requirements
//    }
//}
