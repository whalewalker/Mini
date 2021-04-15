package mini.mappers;

import mini.dtos.UserRegisterDTO;
import mini.models.User;

public class RegisterMapper {
    public static User unpackUser(UserRegisterDTO userRegisterDTO){
        return new User(userRegisterDTO.getFirstName(), userRegisterDTO.getLastName(), userRegisterDTO.getEmail(), userRegisterDTO.getPassword(), userRegisterDTO.getGender());
    }
}
