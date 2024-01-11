package newsWave.wishlist.Service;

import newsWave.wishlist.entity.Wishlist;
import newsWave.wishlist.repository.WishlistRepo;
import newsWave.wishlist.service.WishlistServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WishlistServiceImplTest {

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @Mock
    private WishlistRepo wishlistRepo;

    @Test
    public void testFindAllArticlesFromWishlist() {
        // Arrange
        String email = "test@example.com";
        List<Wishlist> mockWishlists = Arrays.asList(new Wishlist(), new Wishlist());
        when(wishlistRepo.findAllWishlistByEmailId(email)).thenReturn(mockWishlists);

        // Act
        List<Wishlist> result = wishlistService.findAllArticlesFromWishlist(email);

        // Assert
        assertNotNull(result);
        assertEquals(mockWishlists, result);
        // Add more assertions as needed
    }

    @Test
    public void testDeleteArticleFromWishlist_ItemFound() {
        // Arrange
        String email = "test@example.com";
        String wishlistId = "123";
        Wishlist mockWishlist = new Wishlist();
        when(wishlistRepo.findByEmailIdAndId(email, wishlistId)).thenReturn(mockWishlist);

        // Act
        boolean result = wishlistService.deleteArticleFromWishlist(email, wishlistId);

        // Assert
        assertTrue(result);
        // Add more assertions as needed
    }

    @Test
    public void testDeleteArticleFromWishlist_ItemNotFound() {
        // Arrange
        String email = "test@example.com";
        String wishlistId = "123";
        when(wishlistRepo.findByEmailIdAndId(email, wishlistId)).thenReturn(null);

        // Act
        boolean result = wishlistService.deleteArticleFromWishlist(email, wishlistId);

        // Assert
        assertFalse(result);
        // Add more assertions as needed
    }

    @Test
    public void testSaveArticleToWishlist_ItemNotExists() {
        // Arrange
        Wishlist newWishlist = new Wishlist();
        when(wishlistRepo.findByEmailIdAndId(newWishlist.getEmailId(), newWishlist.get_id())).thenReturn(null);
        when(wishlistRepo.save(newWishlist)).thenReturn(newWishlist);

        // Act
        boolean result = wishlistService.saveArticleToWishlist(newWishlist);

        // Assert
        assertTrue(result);
        // Add more assertions as needed
    }

    @Test
    public void testSaveArticleToWishlist_ItemExists() {
        // Arrange
        Wishlist existingWishlist = new Wishlist();
        when(wishlistRepo.findByEmailIdAndId(existingWishlist.getEmailId(), existingWishlist.get_id()))
                .thenReturn(existingWishlist);

        // Act
        boolean result = wishlistService.saveArticleToWishlist(existingWishlist);

        // Assert
        assertFalse(result);
        // Add more assertions as needed
    }

    // Add more test cases as needed
}
