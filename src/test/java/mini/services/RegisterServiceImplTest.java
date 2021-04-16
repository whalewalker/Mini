package mini.services;

import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.mappers.RegisterMapper;
import mini.models.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisterServiceImplTest {
    @Autowired
    RegisterService registerService;

    @Test
    void saveUserToDataBase() throws RegisterUserException {
//      Frontend
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO("Ismail", "Abdullah", "adex@gmail.com", "12345", Gender.MALE);
//        Service
        registerService.registerUser(userRegisterDTO);
//        Assert
        assertEquals(1, registerService.count());
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
        assertEquals(3, registerService.count());
    }

    @Test
    void getAllUserFromDatabase() throws RegisterUserException {
        assertNotNull(registerService.getAllUser());
        assertEquals(3, registerService.count());
    }

    @Test
    void getUserByIdThatDoesNotExistThrowException(){
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO("Dayo", "Micheal", "dayo@gmail.com", "wisdom", Gender.MALE);
        assertNull(RegisterMapper.unpackUser(userRegisterDTO).getId());
    }
}