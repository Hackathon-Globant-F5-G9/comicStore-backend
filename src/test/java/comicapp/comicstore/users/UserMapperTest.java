package comicapp.comicstore.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void testToEntity() {
        UserRequestDTO requestDTO = new UserRequestDTO("John", "userJoe", "Doe", "Marvel", "MArvel");
        User user = UserMapper.toEntity(requestDTO);

        // user.setName(userRequestDTO.name());
        // user.setUsername(userRequestDTO.username());
        // user.setSurname(userRequestDTO.surname());
        // user.setMyComics(userRequestDTO.myComics());
        // user.setFavourites(userRequestDTO.favourites());

        assertEquals("John", user.getName());
        assertEquals("userJoe", user.getSurname());
        assertEquals("Doe", user.getUsername());
    }

    @Test
    void testToResponseDTO() {
        User user = new User("John", "Doe", "johndoe");
        UserResponseDTO responseDTO = UserMapper.toResponseDTO(user);

        assertEquals("John", responseDTO.name());
        assertEquals("Doe", responseDTO.surname());
        assertEquals("johndoe", responseDTO.username());
    }
}