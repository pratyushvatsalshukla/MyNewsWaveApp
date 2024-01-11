package newsWave.wishlist.Controller;
import newsWave.wishlist.controller.WishlistController;
import newsWave.wishlist.entity.Wishlist;
import newsWave.wishlist.service.WishlistServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WishlistControllerTest {

@Mock
private WishlistServiceImpl wishlistService;

@InjectMocks
private WishlistController wishlistController;

@BeforeEach
void setUp() {
    MockitoAnnotations.openMocks(this);
}

@Test
void saveArticleToWishlist() {
    Wishlist article = new Wishlist(1, "testing@gmail.com", "test", "testUser", "abc.com", "Summary","abc", "xyzabc"); // create a Wishlist object

    when(wishlistService.saveArticleToWishlist(article)).thenReturn(true);

    ResponseEntity<?> response = wishlistController.saveArticleToWishlist(article);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals("Article Saved Successfully", response.getBody());

    verify(wishlistService, times(1)).saveArticleToWishlist(article);
}

@Test
void getArticlesFromWishlist() {
    String emailId = "test@example.com";

    List<Wishlist> wishlist = Arrays.asList(new Wishlist(), new Wishlist()); // create a list of Wishlist objects

    when(wishlistService.findAllArticlesFromWishlist(emailId)).thenReturn(wishlist);

    ResponseEntity<?> response = wishlistController.getArticlesFromWishlist(emailId);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(wishlist, response.getBody());

    verify(wishlistService, times(1)).findAllArticlesFromWishlist(emailId);
}

@Test
void deleteArticleFromWishlistSuccess() {
    String id = "123";
    String emailId = "test@example.com" ;
    Wishlist wishlist = new Wishlist(1,emailId,"test","testUser","abc.com","Summary","abc",id); // create a Wishlist object

    when(wishlistService.deleteArticleFromWishlist(emailId, id)).thenReturn(true);

    ResponseEntity<?> response = wishlistController.deleteArticleFromWishlist(wishlist);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Article deleted successfully", response.getBody());

    verify(wishlistService, times(1)).deleteArticleFromWishlist(emailId, id);
}

@Test
void deleteArticleFromWishlistNotFound() {
    String id = "123";
    String emailId = "test@example.com" ;
    Wishlist wishlist = new Wishlist(1,emailId,"test","testUser","abc.com","Summary","abc",id); // create a Wishlist object

    when(wishlistService.deleteArticleFromWishlist(emailId, id)).thenReturn(false);

    ResponseEntity<?> response = wishlistController.deleteArticleFromWishlist(wishlist);

    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    assertEquals("Article not found", response.getBody());

    verify(wishlistService, times(1)).deleteArticleFromWishlist(emailId,id);
}
}
