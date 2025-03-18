package comicapp.comicstore.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindById() {
        User user = new User("John", "Doe", "johndoe");
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findById(user.getId());
        assertTrue(foundUser.isPresent());
        assertEquals("John", foundUser.get().getName());
    }
}