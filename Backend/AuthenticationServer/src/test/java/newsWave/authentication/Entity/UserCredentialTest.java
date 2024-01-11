package newsWave.authentication.Entity;

import newsWave.authentication.entity.UserCredential;
import newsWave.authentication.entity.Wishlist;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCredentialTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        UserCredential userCredential = new UserCredential();
        userCredential.setId(1);
        userCredential.setEmailId("test@example.com");
        userCredential.setPassword("password123");
        Wishlist wishlist = new Wishlist();
        userCredential.setWishlist(List.of(wishlist));

        // Act
        int id = userCredential.getId();
        String emailId = userCredential.getEmailId();
        String password = userCredential.getPassword();
        List<Wishlist> wishlistResult = userCredential.getWishlist();

        // Assert
        assertEquals(1, id);
        assertEquals("test@example.com", emailId);
        assertEquals("password123", password);
        assertEquals(List.of(wishlist), wishlistResult);
    }

    @Test
    public void testParameterizedConstructor() {
        // Arrange
        UserCredential userCredential = new UserCredential(1, "test@example.com", "password123", List.of(new Wishlist()));

        // Act
        int id = userCredential.getId();
        String emailId = userCredential.getEmailId();
        String password = userCredential.getPassword();
        List<Wishlist> wishlistResult = userCredential.getWishlist();

        // Assert
        assertEquals(1, id);
        assertEquals("test@example.com", emailId);
        assertEquals("password123", password);
//        assertEquals(List.of(new Wishlist()), wishlistResult);
    }

    @Test
    public void testDefaultConstructor() {
        // Arrange
        UserCredential userCredential = new UserCredential();

        // Act
        int id = userCredential.getId();
        String emailId = userCredential.getEmailId();
        String password = userCredential.getPassword();
        List<Wishlist> wishlistResult = userCredential.getWishlist();

        // Assert
        assertEquals(0, id);
        assertEquals(null, emailId);
        assertEquals(null, password);
        assertEquals(null, wishlistResult);
    }

    @Test
    public void testTwoParameterConstructor() {
        // Arrange
        UserCredential userCredential = new UserCredential("test@example.com", "password123");

        // Act
        int id = userCredential.getId();
        String emailId = userCredential.getEmailId();
        String password = userCredential.getPassword();
        List<Wishlist> wishlistResult = userCredential.getWishlist();

        // Assert
        assertEquals(0, id);
        assertEquals("test@example.com", emailId);
        assertEquals("password123", password);
        assertEquals(null, wishlistResult);
    }
}
