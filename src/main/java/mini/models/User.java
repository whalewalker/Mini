package mini.models;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Document(collection = "user")
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }
}