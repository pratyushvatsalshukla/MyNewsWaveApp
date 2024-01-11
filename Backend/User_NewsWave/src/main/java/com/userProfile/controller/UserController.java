package com.userProfile.controller;

import com.userProfile.entity.User;
import com.userProfile.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newsWave/")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userService; // Autowiring the User Service Implementation Class
    @PostMapping("/registration")
    public ResponseEntity<?> userRegistration(@RequestBody User user){
        return userService.registerUser(user) ;
    }
    @GetMapping("/getUserById/{email}")
    public ResponseEntity<User> getUserByEmailId(@PathVariable String email) {
        logger.info("Entering User Profile Service - Controller - getUserById");
        return new ResponseEntity<>(userService.getUserByEmailId(email), HttpStatus.OK);
    }

    @PutMapping("/updateDetails")
    public ResponseEntity<User> updateUserDetails(@RequestBody User user) {
        logger.info("Entering User Profile Service - Controller - updateUserDetails");
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    //delete mapping.
    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        logger.info("Entering User Profile Service - Controller - deleteUser");
        return new ResponseEntity<String>(userService.deleteUser(email), HttpStatus.OK);
    }


}



