package mini.services;

import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.models.Gender;
import mini.models.User;

import java.util.List;

public interface RegisterService {
    void registerUser(UserRegisterDTO userRegisterDTO) throws RegisterUserException;
    User findUserById(String id) throws RegisterUserException;
    List<User> findUserByGender(Gender gender) throws RegisterUserException;
    List<User> findUserByFirstNameContaining(String firstName) throws RegisterUserException;
    void deleteAllUser();
    void deleteUserById(String id) throws RegisterUserException;
    User updateUserById(String id, UserRegisterDTO userRegisterDTO) throws RegisterUserException;
    long count() throws RegisterUserException;
    List<User> getAllUser() throws RegisterUserException;
}
