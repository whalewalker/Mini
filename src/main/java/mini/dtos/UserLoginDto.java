package mini.dtos;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginDto {
    @NotNull
    @NonNull
    private String username;

    @NotNull
    @NonNull
    @Digits(fraction = 0, integer = 15)
    private String password;
}
