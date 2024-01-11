package newsWave.authentication.Service;

import newsWave.authentication.entity.UserCredential;
import newsWave.authentication.repository.AuthenticationRepository;
import newsWave.authentication.service.AuthenticationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Mock
    private AuthenticationRepository authRepo;

    @Test
    public void testValidateUser_ValidUser() {
        // Arrange
        UserCredential validUser = new UserCredential("valid@email.com", "password");
        when(authRepo.findByEmailIdAndPassword(validUser.getEmailId(), validUser.getPassword()))
                .thenReturn(validUser);

        // Act
        UserCredential result = authenticationService.validateUser(validUser);

        // Assert
        assertNotNull(result);
        assertEquals(validUser, result);
        // Add more assertions as needed
    }

    @Test
    public void testValidateUser_InvalidUser() {
        // Arrange
        UserCredential invalidUser = new UserCredential("invalid@email.com", "wrongpassword");
        when(authRepo.findByEmailIdAndPassword(invalidUser.getEmailId(), invalidUser.getPassword()))
                .thenReturn(null);

        // Act
        UserCredential result = authenticationService.validateUser(invalidUser);

        // Assert
        assertNull(result);
        // Add more assertions as needed
    }

    // Add more test cases as needed
}
