package mini.services;

import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.models.Gender;
import mini.models.User;

import java.util.List;

public interface RegisterService {
    void registerUser(UserRegisterDTO userRegisterDTO) throws RegisterUserException;
}
