package comicapp.comicstore.comics;

public class ComicMapper {

    public static Comic toEntity(ComicRequestDTO comicRequestDTO) {
        Comic comic = new Comic();
        comic.setISBN(comicRequestDTO.ISBN());
        comic.setName(comicRequestDTO.name());
        comic.setAuthor(comicRequestDTO.author());
        comic.setEditorial(comicRequestDTO.editorial());
        comic.setGenre(comicRequestDTO.genre());
        comic.setDescription(comicRequestDTO.description());
        comic.setState(Comic.State.valueOf(comicRequestDTO.state().toUpperCase())); // Convert String to enum
        comic.setPrice(comicRequestDTO.price());
        comic.setImageUrl(comicRequestDTO.imageUrl());
        return comic;
    }

    public static ComicResponseDTO toResponseDTO(Comic comic) {
        return new ComicResponseDTO(
                comic.getId(),
                comic.getISBN(),
                comic.getName(),
                comic.getAuthor(),
                comic.getEditorial(),
                comic.getGenre(),
                comic.getDescription(),
                comic.getState().name(), // Convert enum to String
                comic.getPrice(),
                comic.getImageUrl());
    }
}