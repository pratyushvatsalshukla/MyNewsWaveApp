package newsWave.authentication.service;
import newsWave.authentication.entity.UserCredential;
import newsWave.authentication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    AuthenticationRepository authRepo;

    @Override
    public UserCredential validateUser(UserCredential user) {
        UserCredential userFinded =  authRepo.findByEmailIdAndPassword(user.getEmailId(),user.getPassword()) ;
            if(userFinded != null){
                return userFinded ;
            }
            else{
                return null ;
            }
    }
}
