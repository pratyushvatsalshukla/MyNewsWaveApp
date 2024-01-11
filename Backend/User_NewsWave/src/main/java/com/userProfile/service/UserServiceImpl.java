package com.userProfile.service;

import com.google.gson.Gson;
import com.userProfile.Filter.JwtTokenFilter;
import com.userProfile.entity.User;
import com.userProfile.entity.Wishlist;
import com.userProfile.exceptions.InvalidPasswordException;
import com.userProfile.exceptions.NameCanNotBeBlankException;
import com.userProfile.exceptions.UserAlreadyExistsException;
import com.userProfile.exceptions.UserNotFoundException;
import com.userProfile.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Objects;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo ;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate ;

    @Autowired
    private Gson gson = new Gson() ;

    @Autowired
    private RestTemplate restTemplate ;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class) ;

    @Override
    public User getUserByEmailId(String email) {

        User userByEmailId = userRepo.findByEmailId(email);
        if(Objects.nonNull(userByEmailId)){
            logger.info("Entered getUserByEmail and User Found !!") ;
            logger.warn("Calling Wishlist Microservice To Get Wishlist Data !") ;
            String finalUrl = "http://localhost:8085/wishlist/viewWishlist/"+email ;
            ArrayList<Wishlist> forObject = restTemplate.exchange(finalUrl, HttpMethod.GET,getEntity(), ArrayList.class).getBody() ;
            if(Objects.nonNull(forObject)) {
                logger.info("User Wishlist Data Found !!"+forObject);
                userByEmailId.setWishlist(forObject);
            }
            else{
                userByEmailId.setWishlist(null);
            }
            return userByEmailId ;
        }
        else{
            throw new UserNotFoundException(email) ;
        }
    }
    public HttpEntity<?> getEntity() {
        String finalRequest = "Bearer "+ JwtTokenFilter.generatedToken ;
        System.out.println("FINAL REQUEST : "+ finalRequest );
        HttpHeaders headers = new HttpHeaders() ;
        logger.warn("Setting Headers For API Calling...") ;
        headers.set("Authorization",finalRequest) ;
        logger.info("Finished Setting Headers For API Calling Successfully...") ;
        return new HttpEntity<>(headers) ;
    }

    @Override
    public ResponseEntity<?> registerUser(User user) {
        User userByEmailId = userRepo.findByEmailId(user.getEmailId());
        try {
            if (Objects.nonNull(userByEmailId)) {
                throw new UserAlreadyExistsException(user.getEmailId());
            }
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        try {
            if (user.getName().isBlank()) {
                throw new NameCanNotBeBlankException("Name Can Not Be Blank Or Number" );
            } else if (user.getPassword().length() < 6) {
                {
                    throw new InvalidPasswordException("Password Can Not Be Less Than 6 Characters");
                }
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        userRepo.save(user);
        sendPayload("exchange",user);
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.CREATED);

    }


    @Override
    public User updateUser(User user) {
        logger.info("Entered User Profile Service - Services - updateUser") ;
       User userByEmail = userRepo.findUserByEmailId(user.getEmailId()) ;
       if(Objects.nonNull(userByEmail) && user.getPassword().equals(userByEmail.getPassword())){
           if(userByEmail.getName() != null){
               userByEmail.setName(user.getName());
           }
           return userRepo.save(userByEmail) ;
       }
       else{
           throw new UserNotFoundException(user.getEmailId()) ;
       }
    }

    @Override
    public String deleteUser(String email) {
        User userByEmailId = userRepo.findUserByEmailId(email);
        if(Objects.nonNull(userByEmailId)){
            logger.warn("User Deletion in Progress...") ;
            userRepo.delete(userByEmailId);
            logger.info("User Deleted Successfully !!") ;
            return "User Deleted !" ;
        }
        else{
            logger.error("No User Found, So Can Not Delete Non-Existing User !!") ;
            throw new UserNotFoundException(email) ;
        }
    }


    @Override
    public void sendPayload(String topic, User payload) {
        String jsonPayLoad = gson.toJson(payload) ;
        logger.info("Sending Payload To Kafka Topic...") ;
        kafkaTemplate.send(topic,jsonPayLoad);
        logger.info("Payload Sent Successfully !!"+ topic) ;
        logger.info("Payload : "+jsonPayLoad);
    }


}
