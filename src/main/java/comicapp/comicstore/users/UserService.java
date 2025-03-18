package comicapp.comicstore.users;

import comicapp.comicstore.exceptions.ComicStoreNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = UserMapper.toEntity(userRequestDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponseDTO(savedUser);
    }

    public List<UserResponseDTO> findAll(){
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserMapper::toResponseDTO).toList();
    }

    public UserResponseDTO findById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new ComicStoreNotFoundException("The user with id " + id + "does not exist.");
        }
        User user = optionalUser.get();
        return UserMapper.toResponseDTO(user);
    }
}
