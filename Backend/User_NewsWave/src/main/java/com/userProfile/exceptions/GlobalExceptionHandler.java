package com.userProfile.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NameCanNotBeBlankException.class)
    public ResponseEntity<String> handleNameCanNotBeBlankException(NameCanNotBeBlankException ex){
//        return ResponseEntity.badRequest().body(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

//    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex){
//        return ResponseEntity.badRequest().body(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmailIdCanNotBeBlankException.class)
    public ResponseEntity<String> handleEmailIdCanNotBeBlankException(EmailIdCanNotBeBlankException ex){
//        return ResponseEntity.badRequest().body(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<String> handlePasswordCanNotBeBlankException(InvalidPasswordException ex){
//        return ResponseEntity.badRequest().body(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);

    }


}
