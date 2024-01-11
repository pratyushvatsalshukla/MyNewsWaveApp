package newsWave.authentication.Repository;

import newsWave.authentication.entity.UserCredential;
import newsWave.authentication.repository.AuthenticationRepository;
import newsWave.authentication.service.AuthenticationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AuthenticationRepositoryTest {

    @Mock
    private AuthenticationRepository authenticationRepository;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByEmailIdAndPassword() {
        // Arrange
        String email = "test@example.com";
        String password = "password123";
        UserCredential expectedUserCredential = new UserCredential(1, email, password, null);

        when(authenticationRepository.findByEmailIdAndPassword(email, password)).thenReturn(expectedUserCredential);

        // Act
        UserCredential result = authenticationRepository.findByEmailIdAndPassword(email, password);

        // Assert
        assertEquals(expectedUserCredential, result);
    }

    @Test
    public void testFindUserCredentialByEmailId() {
        // Arrange
        String emailId = "test@example.com";
        UserCredential expectedUserCredential = new UserCredential(1, emailId, "password123", null);

        when(authenticationRepository.findUserCredentialByEmailId(emailId)).thenReturn(expectedUserCredential);

        // Act
        UserCredential result = authenticationRepository.findUserCredentialByEmailId(emailId);

        // Assert
        assertEquals(expectedUserCredential, result);
    }
}
