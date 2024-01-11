package test.Service;

import com.userProfile.entity.User;
import com.userProfile.exceptions.UserNotFoundException;
import com.userProfile.repository.UserRepository;
import com.userProfile.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testRegisterUser_Success() {
        // Arrange
        User newUser = new User(1,"Dummy", "Dummy@gmail.com", "DummyPass", null);
        when(userRepository.findByEmailId(newUser.getEmailId())).thenReturn(null);

        // Act
        ResponseEntity<?> result = userService.registerUser(newUser);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(userRepository, times(1)).save(newUser);
        verify(kafkaTemplate, times(1)).send(anyString(), anyString());
        // Add more assertions as needed
    }

    @Test
    public void testUpdateUser_Success() {
        User existingUser = new User(1, "existingUser","existing@example.com", "existingPassword", null);
        User updatedUser = new User(1, "updatedUser","existing@example.com", "existingPassword", null);
        when(userRepository.findUserByEmailId("existing@example.com")).thenReturn(existingUser);
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User resultUser = userService.updateUser(updatedUser);
        verify(userRepository, times(1)).findUserByEmailId("existing@example.com");
        verify(userRepository, times(1)).save(existingUser);

        // Assertions
        assertEquals(updatedUser.getName(), resultUser.getName());

    }

    @Test(expected = UserNotFoundException.class)
    public void testUpdateUser_UserNotFound() {
        // Arrange
        User nonExistingUser = new User();
        nonExistingUser.setEmailId("nonexistent@example.com");
        when(userRepository.findUserByEmailId(nonExistingUser.getEmailId())).thenReturn(null);

        // Act & Assert
        userService.updateUser(nonExistingUser);
        assertNull(nonExistingUser.getEmailId());
    }

    @Test
    public void testDeleteUser_Success() {
        // Arrange
        String userEmail = "test@example.com";
        User existingUser = new User();
        existingUser.setEmailId(userEmail);
        when(userRepository.findUserByEmailId(userEmail)).thenReturn(existingUser);

        // Act
        String result = userService.deleteUser(userEmail);

        // Assert
        assertEquals("User Deleted !", result);
        verify(userRepository, times(1)).delete(existingUser);
        // Add more assertions as needed
    }

    @Test(expected = UserNotFoundException.class)
    public void testDeleteUser_UserNotFound() {
        // Arrange
        String nonExistingEmail = "nonexistent@example.com";
        when(userRepository.findUserByEmailId(nonExistingEmail)).thenReturn(null);

        // Act & Assert
        userService.deleteUser(nonExistingEmail);
    }

    // Add more test cases as needed
}
