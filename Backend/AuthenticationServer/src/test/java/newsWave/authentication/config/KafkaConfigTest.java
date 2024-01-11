package newsWave.authentication.config;

import com.google.gson.Gson;
import newsWave.authentication.repository.AuthenticationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaConfigTest {

    @Mock
    private AuthenticationRepository authRepo;

    @Mock
    private Gson gson;

    @Spy
    @InjectMocks
    private KafkaConfig kafkaConfig;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testConsumeCredentials() throws JsonProcessingException {
//        // Arrange
//        String jsonValue = "{\"emailId\":\"test@example.com\",\"password\":\"password123\"}";
//
//        Map<String, String> responseMap = new HashMap<>();
//        responseMap.put("emailId", "test@example.com");
//        responseMap.put("password", "password123");
//
//        when(gson.fromJson(jsonValue, Map.class)).thenReturn(responseMap);
//
//        // Act
//        kafkaConfig.consumeCredentials(jsonValue);
//
//        // Assert
//        verify(authRepo, times(1)).save(any(UserCredential.class));
//    }
}

