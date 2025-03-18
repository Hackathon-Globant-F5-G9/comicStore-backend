package comicapp.comicstore.users;

import comicapp.comicstore.comics.Comic;
import comicapp.comicstore.users.User;
import jakarta.validation.constraints.*;

public record UserRequestDTO (

    Long id,

    @NotNull(message = "The name cannot be null")
    String name,

    @NotNull(message = "The surname cannot be null")
    String surname,

    @NotNull(message = "The username cannot be null")
    String username,

    Comic myComics,

    Comic favourites
){
}
