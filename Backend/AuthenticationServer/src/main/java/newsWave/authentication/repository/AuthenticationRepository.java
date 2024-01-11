package newsWave.authentication.repository;

import newsWave.authentication.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<UserCredential,Integer> {

    // SELECT emailId AND password FROM User WHERE emailId = ? AND password = ?;
    // If Found, it will return Object. Otherwise it will return '0'
    UserCredential findByEmailIdAndPassword(String email, String password) ;  // Custom Method

    @Query("select  u from UserCredential u where u.emailId = ?1")
    UserCredential findUserCredentialByEmailId(String emailId);

}
