package newsWave.authentication.controller;

import newsWave.authentication.Configuration.JwtTokenGen;
import newsWave.authentication.entity.UserCredential;
import newsWave.authentication.exceptions.UserNotFoundException;
import newsWave.authentication.service.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/authorization/")
public class AuthenticationController {

    @Autowired
    AuthenticationServiceImpl authService ;
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserCredential userAuth) {
        UserCredential result=authService.validateUser(userAuth);
        try{
            if (userAuth.getEmailId() == null || userAuth.getPassword() == null) {
                throw new UserNotFoundException("email OR password is null");
            }

            if(Objects.nonNull(result))
            {
                Map<String, String> token= new JwtTokenGen().generateToken(result);
                return new ResponseEntity<Map>(token,HttpStatus.OK);
            }else if (Objects.isNull(result)) {
                throw new UserNotFoundException(userAuth.getEmailId());
            }
        }
        catch (UserNotFoundException e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Invalid user",HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }
    }


