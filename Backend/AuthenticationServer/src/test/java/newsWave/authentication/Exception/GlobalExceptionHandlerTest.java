package newsWave.authentication.Exception;

import newsWave.authentication.exceptions.GlobalExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void handleNameCanNotBeBlankException() {
        // ... (unchanged)
    }

    @Test
    public void handleEmailIdCanNotBeBlankException() {
        // ... (unchanged)
    }

    @Test
    public void handlePasswordCanNotBeBlankException() {
        // ... (unchanged)
    }
}
