import org.example.model.User;
import org.example.service.PetStoreClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTests {
    static PetStoreClient apiClient = new PetStoreClient();

    @Test
    void shouldCreateUserAndReturnEntity() {
        Random random = new Random();
        String username = "test" + random.nextInt();
        String firstName = "test" + random.nextInt();
        String lastName = "test" + random.nextInt();
        String email = "test" + random.nextInt();
        String password = "test" + random.nextInt();
        String phone = String.valueOf(random.nextInt());
        int userStatus = random.nextInt(10);

        User createdUser = User.builder()
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .password(password)
                .userStatus(userStatus)
                .build();
        apiClient.createUser(createdUser);

        User retrievedUser = apiClient.getUser(username);

        Assertions.assertAll(
                () -> assertEquals(createdUser.getFirstName(), retrievedUser.getFirstName()),
                () -> assertEquals(createdUser.getLastName(), retrievedUser.getLastName()),
                () -> assertEquals(createdUser.getEmail(), retrievedUser.getEmail()),
                () -> assertEquals(createdUser.getPhone(), retrievedUser.getPhone()),
                () -> assertEquals(createdUser.getPassword(), retrievedUser.getPassword()),
                () -> assertEquals(createdUser.getUserStatus(), retrievedUser.getUserStatus())
        );

    }
}
