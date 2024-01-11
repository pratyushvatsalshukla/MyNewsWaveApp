package newsWave.authentication.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import newsWave.authentication.entity.UserCredential;
import newsWave.authentication.repository.AuthenticationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Map;

@Configuration
public class KafkaConfig {
    @Autowired
    AuthenticationRepository authRepo;
    @Autowired
    Gson gson;

//    @Autowired
//    UserCredential userCredential ;
    UserCredential userCredential = new UserCredential();

    private static final Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = "exchange", groupId = "mygroup")
    public void consumeCredentials(String value) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,String> responseMap = objectMapper.readValue(value, Map.class) ;


        userCredential.setEmailId(responseMap.get("emailId"));
        userCredential.setPassword(responseMap.get("password"));
    authRepo.save(userCredential);
//        User user = gson.fromJson(value, User.class);
//        System.out.println("Consumed Message : -" + user.getEmailId() + user.getPassword());
//        authRepo.save(user);

    }
}
