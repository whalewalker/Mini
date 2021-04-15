package mini.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import mini.models.Gender;
import mini.models.User;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UserRegisterDTO {

    @NotNull
    @NonNull
    private String firstName;

    @NotNull
    @NonNull
    private String lastName;

    @Email
    @NonNull
    private String email;

    @Digits(integer = 15, fraction = 0)
    @NotNull
    @NonNull
    private String password;

    @NotNull
    @NonNull
    private Gender gender;

}
