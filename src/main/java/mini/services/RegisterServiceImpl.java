package mini.services;

import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.mappers.RegisterMapper;
import mini.models.User;
import mini.repositories.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    RegisterUserRepository registerUserRepository;

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) throws RegisterUserException {
        User userToSave = RegisterMapper.unpackUser(userRegisterDTO);
        Optional<User> user = registerUserRepository.findUserByEmail(userRegisterDTO.getEmail());
       if(user.isPresent()) throw new RegisterUserException("user already exist");
        save(userToSave);
    }

    private void save(User userToSave) throws RegisterUserException {
        registerUserRepository.save(userToSave);
    }
}
