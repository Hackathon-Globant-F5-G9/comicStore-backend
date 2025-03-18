package comicapp.comicstore.users;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById() {
        User user = new User("John", "Doe", "johndoe");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
        assertEquals("John", foundUser.getName());
    }

    @Test
    void testCreateUser() {
        User user = new User("John", "Doe", "johndoe");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);
        assertNotNull(createdUser);
        assertEquals("John", createdUser.getName());
    }
}