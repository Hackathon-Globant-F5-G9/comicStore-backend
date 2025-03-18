package comicapp.comicstore.comics;

public record ComicResponseDTO(
        Long id,
        String ISBN,
        String name,
        String author,
        String editorial,
        String genre,
        String description,
        String state,
        float price,
        String imageUrl
) {
}