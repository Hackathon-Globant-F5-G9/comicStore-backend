package comicapp.comicstore.users;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/users")

public @interface UserController {

    private final UserService userService;
    private UserRepository userRepository;
    private final UserMapper userMapper;

}
