//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class ServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testGetUserByEmailId() {
//        // Mocking userRepository.findByEmailId method
//        when(userRepository.findByEmailId("test@example.com")).thenReturn(new User(/* Provide user details here */));
//
//        // Mocking restTemplate.getForObject method
//        when(restTemplate.getForObject("http://localhost:8085/wishlist/viewWishlist/test@example.com", ArrayList.class))
//                .thenReturn(new ArrayList<>(Collections.singletonList(new Wishlist(/* Provide wishlist details here */))));
//
//        // Call the method to be tested
//        User result = userService.getUserByEmailId("test@example.com");
//
//        // Verify that userRepository.findByEmailId was called with the expected parameter
//        verify(userRepository).findByEmailId("test@example.com");
//
//        // Verify that restTemplate.getForObject was called with the expected parameter
//        verify(restTemplate).getForObject("http://localhost:8085/wishlist/viewWishlist/test@example.com", ArrayList.class);
//
//        // Add more assertions as needed
//        // Example: assertNotNull(result);
//        // Example: assertNotNull(result.getWishlist());
//    }
//
//    @Test
//    void testUpdateUser() {
//        // Mocking userRepository.findUserByEmailId method
//        when(userRepository.findUserByEmailId("test@example.com")).thenReturn(new User(/* Provide user details here */));
//
//        // Mocking userRepository.save method
//        when(userRepository.save(any(User.class))).thenReturn(new User(/* Provide updated user details here */));
//
//        // Call the method to be tested
//        User result = userService.updateUser(new User(/* Provide user details here */));
//
//        // Verify that userRepository.findUserByEmailId was called with the expected parameter
//        verify(userRepository).findUserByEmailId("test@example.com");
//
//        // Verify that userRepository.save was called with the expected parameter
//        verify(userRepository).save(any(User.class));
//
//        // Add more assertions as needed
//        // Example: assertNotNull(result);
//    }
//
//    @Test
//    void testDeleteUser() {
//        // Mocking userRepository.findUserByEmailId method
//        when(userRepository.findUserByEmailId("test@example.com")).thenReturn(new User(/* Provide user details here */));
//
//        // Call the method to be tested
//        String result = userService.deleteUser("test@example.com");
//
//        // Verify that userRepository.findUserByEmailId was called with the expected parameter
//        verify(userRepository).findUserByEmailId("test@example.com");
//
//        // Verify that userRepository.delete was called with the expected parameter
//        verify(userRepository).delete(any(User.class));
//
//        // Add more assertions as needed
//        // Example: assertEquals("User Deleted !", result);
//    }
//
//    // Add more test cases as needed
//}
