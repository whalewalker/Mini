package mini.services;

import mini.dtos.UserLoginDto;
import mini.exceptions.UserLoginException;

public interface LoginService {
    boolean isLoggedIn(UserLoginDto loginDto) throws UserLoginException;
}
