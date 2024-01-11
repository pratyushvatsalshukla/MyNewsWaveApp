//package newsWave.wishlist.RepositoryTest;
//
//import newsWave.wishlist.entity.Wishlist;
//import newsWave.wishlist.repository.WishlistRepo;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class WishlistRepositoryTest {
//
//    @InjectMocks
//    private WishlistRepo wishlistRepo;
//
//    @Mock
//    private JpaRepository<Wishlist, String> jpaRepository;
//
//    @Test
//    public void testFindAllWishlistByEmailId() {
//        // Arrange
//        String email = "test@example.com";
//        List<Wishlist> mockWishlists = Arrays.asList(new Wishlist(), new Wishlist());
//        when(wishlistRepo.findAllWishlistByEmailId(email)).thenReturn(mockWishlists);
//
//        // Act
//        List<Wishlist> result = wishlistRepo.findAllWishlistByEmailId(email);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(mockWishlists, result);
//        // Add more assertions as needed
//    }
//
//    @Test
//    public void testFindByEmailIdAndId() {
//        // Arrange
//        String email = "test@example.com";
//        String wishlistId = "123";
//        Wishlist mockWishlist = new Wishlist();
//        when(wishlistRepo.findByEmailIdAndId(email, wishlistId)).thenReturn(mockWishlist);
//
//        // Act
//        Wishlist result = wishlistRepo.findByEmailIdAndId(email, wishlistId);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(mockWishlist, result);
//        // Add more assertions as needed
//    }
//
//    // Add more test cases for other methods as needed
//}
