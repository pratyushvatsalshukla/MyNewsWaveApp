package com.userProfile.repository;

import com.userProfile.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    // SELECT emailId AND password FROM User WHERE emailId = ? AND password = ?;
    // If Found, it will return Object. Otherwise it will return 0'
    User findByEmailIdAndPassword(String email, String password) ;  // Custom Method

    @Query("select  u from User u where u.emailId = ?1")
    User findUserByEmailId(String emailId);

    User findByEmailId(String emailId);
}
