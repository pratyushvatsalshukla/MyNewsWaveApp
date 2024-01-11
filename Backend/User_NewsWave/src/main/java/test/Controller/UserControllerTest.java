package test.Controller;

import com.userProfile.controller.UserController;
import com.userProfile.entity.User;
import com.userProfile.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @Test
    public void testUserRegistration() {
        // Arrange
        User newUser = new User();
        when(userService.registerUser(newUser)).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));

        // Act
        ResponseEntity<?> result = userController.userRegistration(newUser);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        // Add more assertions as needed
    }

    @Test
    public void testGetUserByEmailId() {
        // Arrange
        String userEmail = "test@example.com";
        User mockUser = new User();
        when(userService.getUserByEmailId(userEmail)).thenReturn(mockUser);

        // Act
        ResponseEntity<User> result = userController.getUserByEmailId(userEmail);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(mockUser, result.getBody());
        // Add more assertions as needed
    }

    @Test
    public void testUpdateUserDetails() {
        // Arrange
        User updatedUser = new User();
        when(userService.updateUser(updatedUser)).thenReturn(updatedUser);

        // Act
        ResponseEntity<User> result = userController.updateUserDetails(updatedUser);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(updatedUser, result.getBody());
        // Add more assertions as needed
    }

    @Test
    public void testDeleteUser() {
        // Arrange
        String userEmail = "test@example.com";
        when(userService.deleteUser(userEmail)).thenReturn("User deleted successfully");

        // Act
        ResponseEntity<String> result = userController.deleteUser(userEmail);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("User deleted successfully", result.getBody());
        // Add more assertions as needed
    }

    // Add more test cases as needed
}
