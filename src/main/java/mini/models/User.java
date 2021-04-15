package mini.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Document(collation = "User")
@RequiredArgsConstructor
public class User {
    @Id
    private String id;

    @NotNull
    @NonNull
    private String firstName;

    @NotNull
    @NonNull
    private String lastName;

    @Email
    @NonNull
    private String email;

    @Digits(integer = 10, fraction = 15)
    @NotNull
    @NonNull
    private String password;

    @NotNull
    @NonNull
    private Gender gender;

}