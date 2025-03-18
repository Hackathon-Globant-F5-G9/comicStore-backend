package comicapp.comicstore.users;

import comicapp.comicstore.comics.Comic;
import comicapp.comicstore.users.User;
import jakarta.validation.constraints.*;

public record UserResponseDTO(
                Long id,
                String name,
                String username,
                Comic myComics,
                Comic favourites

) {

}
