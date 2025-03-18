package comicapp.comicstore.comics;

public record ComicResponseDTO(
        Long id,
        Long ISBN,
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