package comicapp.comicstore.users;

import java.util.Set;

public class UserMapper {
    public static User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.name());
        user.setUsername(userRequestDTO.username());
        user.setSurname(userRequestDTO.surname());
        user.setMyComics(userRequestDTO.myComics());
        user.setFavourites(userRequestDTO.favourites());
        return user;

    }

    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getMyComics(),
                user.getFavourites());
    }
}
