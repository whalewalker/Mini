package mini.repositories;

import mini.models.Gender;
import mini.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterUserRepository extends MongoRepository<User, String> {
    List<User> findUserByGender(Gender gender);
    Optional<User> findUserByEmail(String email);
    List<User> findUserByFirstNameContaining(String firstName);
}
