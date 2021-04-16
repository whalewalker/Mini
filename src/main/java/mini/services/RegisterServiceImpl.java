package mini.services;

import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.mappers.RegisterMapper;
import mini.models.Gender;
import mini.models.User;
import mini.repositories.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    private User save(User userToSave) throws RegisterUserException {
        return registerUserRepository.save(userToSave);
    }

    @Override
    public User findUserById(String id) throws RegisterUserException {
        Optional<User> userToFind = registerUserRepository.findById(id);
        if(userToFind.isPresent()){
            return userToFind.get();
        }else throw new RegisterUserException("User with this id does not exist");
    }



    @Override
    public List<User> findUserByGender(Gender gender) throws RegisterUserException {
        List<User> userToFind = registerUserRepository.findUserByGender(gender);
        UserIsValid(userToFind.isEmpty(), "No users found");
        return userToFind;
    }

    @Override
    public List<User> findUserByFirstNameContaining(String firstName) throws RegisterUserException {
        List<User> usersToFind = registerUserRepository.findUserByFirstNameContaining(firstName);
        UserIsValid(usersToFind.isEmpty(), "No users found");
        return usersToFind;
    }

    private void UserIsValid(boolean empty, String message) throws RegisterUserException {
        if (empty) throw new RegisterUserException(message);
    }

    @Override
    public void deleteAllUser() {
        deleteAllUserFromDb();
    }

    private void deleteAllUserFromDb() {
        registerUserRepository.deleteAll();
    }

    @Override
    public void deleteUserById(String id) throws RegisterUserException {
        deleteUserFromDb(id);
    }

    private void deleteUserFromDb(String id) throws RegisterUserException {
        if(findUserById(id) == null) throw new RegisterUserException(("User with this id does not exist"));
        registerUserRepository.deleteById(id);
    }

    @Override
    public User updateUserById(String id, UserRegisterDTO userDetails) throws RegisterUserException {
        User user = findUserById(id);
        if(!user.getFirstName().equals(userDetails.getFirstName())){
            user.setFirstName(userDetails.getFirstName());
        }
        if(!user.getLastName().equals(userDetails.getLastName())){
            user.setLastName(userDetails.getLastName());
        }
        if(!user.getEmail().equals(userDetails.getEmail())){
            user.setEmail(userDetails.getEmail());
        }
        if(!user.getPassword().equals(userDetails.getPassword())){
            user.setPassword(userDetails.getPassword());
        }

        if(!user.getGender().equals(userDetails.getGender())){
            user.setGender(userDetails.getGender());
        }

        return save(user);
    }

    @Override
    public long count() throws RegisterUserException {
        return registerUserRepository.count();
    }


    @Override
    public List<User> getAllUser() throws RegisterUserException {
        List<User> users = registerUserRepository.findAll();
        if(users.isEmpty()) throw new RegisterUserException("User not found");
        return users;
    }
}
