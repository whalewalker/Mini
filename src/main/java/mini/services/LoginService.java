package mini.services;

import mini.dtos.UserLoginDTO;
import mini.exceptions.UserLoginException;

public interface LoginService {
    boolean isLoggedIn(UserLoginDTO loginDto) throws UserLoginException;
}
