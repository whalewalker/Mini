package mini.services;

import mini.dtos.UserLoginDto;
import mini.exceptions.UserLoginException;
import mini.models.User;
import mini.repositories.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    RegisterUserRepository registerUserRepository;

    @Override
    public boolean isLoggedIn(UserLoginDto loginDto) throws UserLoginException {
        return isValid(loginDto.getUsername(), loginDto.getPassword());
    }

    private boolean isValid(String email, String password) throws UserLoginException {
        Optional<User> user = registerUserRepository.findUserByEmail(email);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)) return true;
            else throw new UserLoginException("Password is incorrect");
        }else throw new UserLoginException("User not found");
    }
}
