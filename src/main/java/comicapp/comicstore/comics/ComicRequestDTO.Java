package comicapp.comicstore.comics;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ComicRequestDTO(
    Long id,

    @NotNull(message = "The ISBN cannot be null")
    Long ISBN,

    @NotEmpty(message = "The name cannot be empty")
    String name,

    @NotEmpty(message = "The author cannot be empty")
    String author,

    @NotEmpty(message = "The editorial cannot be empty")
    String editorial,

    @NotEmpty(message = "The genre cannot be empty")
    String genre,

    String description,

    //@NotNull(message = "The state cannot be null")
    Enum state,

    //@NotNull(message = "The price cannot be null")
    float price,

    //@NotEmpty(message = "The imageUrl cannot be empty")
    String imageUrl
){
}