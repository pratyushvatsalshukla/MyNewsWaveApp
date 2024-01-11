package newsWave.authentication.service;

import newsWave.authentication.entity.UserCredential;

public interface AuthenticationService {


    UserCredential validateUser(UserCredential user) ;

}
