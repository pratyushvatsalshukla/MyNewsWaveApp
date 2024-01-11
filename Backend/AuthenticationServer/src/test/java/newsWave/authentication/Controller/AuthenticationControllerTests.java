package newsWave.authentication.Controller;

import newsWave.authentication.controller.AuthenticationController;
import newsWave.authentication.entity.UserCredential;
import newsWave.authentication.service.AuthenticationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerTests {

    @InjectMocks
    private AuthenticationController authenticationController;

    @Mock
    private AuthenticationServiceImpl authenticationService;

    @Test
    public void testLoginUser_ValidCredentials() {
        // Arrange
        UserCredential validUser = new UserCredential("valid@email.com", "password");
        when(authenticationService.validateUser(validUser)).thenReturn(validUser);

        // Act
        ResponseEntity<?> responseEntity = authenticationController.loginUser(validUser);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        // Add more assertions as needed
    }

    @Test
    public void testLoginUser_InvalidCredentials() {
        // Arrange
        UserCredential invalidUser = new UserCredential("invalid@email.com", "wrongpassword");
        when(authenticationService.validateUser(invalidUser)).thenReturn(null);

        // Act
        ResponseEntity<?> responseEntity = authenticationController.loginUser(invalidUser);

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        // Add more assertions as needed
    }

    @Test
    public void testLoginUser_NullCredentials() {
        // Arrange
        UserCredential nullCredentials = new UserCredential(null, null);

        // Act
        ResponseEntity<?> responseEntity = authenticationController.loginUser(nullCredentials);

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        // Add more assertions as needed
    }

    // Add more test cases as needed
}

