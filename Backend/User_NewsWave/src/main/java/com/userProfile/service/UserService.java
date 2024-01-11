package com.userProfile.service;

import com.userProfile.entity.User;
import com.userProfile.exceptions.EmailIdCanNotBeBlankException;
import com.userProfile.exceptions.InvalidPasswordException;
import com.userProfile.exceptions.NameCanNotBeBlankException;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User updateUser(User user) ;

    String deleteUser(String email) ;

    User getUserByEmailId(String email) ;

    ResponseEntity<?> registerUser(User user) throws NameCanNotBeBlankException, InvalidPasswordException, EmailIdCanNotBeBlankException;

    void sendPayload(String topic, User payload) ;

}