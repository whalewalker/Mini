package mini.services;

import mini.dtos.UserLoginDto;
import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.exceptions.UserLoginException;
import mini.mappers.RegisterMapper;
import mini.models.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;

    @Autowired
    RegisterService registerService;

    @Autowired
    LoginService loginService;

    @Test
    void saveUserToDataBase() throws RegisterUserException {
//      Frontend
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO("Ismail", "Abdullah", "adex@gmail.com", "12345", Gender.MALE);
//        Service
        registerService.registerUser(userRegisterDTO);
//        Assert
        assertEquals(1, userService.count());
    }

    @Test
    void saveMoreThanOneUser() throws RegisterUserException {
//      Frontend
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO("Dayo", "Micheal", "dayo@gmail.com", "wisdom", Gender.MALE);
        UserRegisterDTO anotherUser = new UserRegisterDTO("Ismail", "suliat", "suliat@gmail.com","12345", Gender.FEMALE);
//        Service
        registerService.registerUser(userRegisterDTO);
        registerService.registerUser(anotherUser);
//        Assert
        assertEquals(3, userService.count());
    }

    @Test
    void getAllUserFromDatabase() throws RegisterUserException {
        assertNotNull(userService.getAllUser());
        assertEquals(6, userService.count());
    }

    @Test
    void getUserByIdThatDoesNotExistThrowException(){
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO("Dayo", "Micheal", "dayo@gmail.com", "wisdom", Gender.MALE);
        assertNull(RegisterMapper.unpackUser(userRegisterDTO).getId());
    }

    @Test
    void checkIfUserCanLogin() throws UserLoginException {
        UserLoginDto loginDto = new UserLoginDto("adex@gmail.com", "12345");
        boolean isValid = loginService.isLoggedIn(loginDto);
        assertTrue(isValid);
    }

    @Test
    void throwUserLoginExceptionIfUserDoesNotExist(){
        UserLoginDto loginDto = new UserLoginDto("lalal@gmail.com", "1234");
        assertThrows(UserLoginException.class, ()-> loginService.isLoggedIn(loginDto));
    }

    @Test
    void throwUserLoginExceptionIfPasswordIsNotCorrect(){
        UserLoginDto loginDto = new UserLoginDto("adex@gmail.com", "abdce");
        assertThrows(UserLoginException.class, ()-> loginService.isLoggedIn(loginDto));
    }
}
