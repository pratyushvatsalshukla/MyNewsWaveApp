package newsWave.authentication.Configuration;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import newsWave.authentication.entity.UserCredential;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenGen {

    public Map<String, String> generateToken(UserCredential user) {

        String jwtToken = "";
        /*
         * Generate JWT token and store in String jwtToken
         */
        Map<String, String> jwtTokenMap = new HashMap<>();
        Map<String, Object> userdata = new HashMap<>();
        userdata.put("email", user.getEmailId());
        userdata.put("password", user.getPassword());
        jwtToken = Jwts.builder()
                .setClaims(userdata)
                .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+1800000))
                .signWith(SignatureAlgorithm.HS256, "secret").compact();
        jwtTokenMap.put("token", jwtToken);
        jwtTokenMap.put("message", "Login Successful");
        jwtTokenMap.put("emailId", user.getEmailId()) ;
//        jwtTokenMap.put("name",user.getName()) ;
        System.out.println("Token Generated");
        return jwtTokenMap;
    }

}
