package comicapp.comicstore.comics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComicRepository extends JpaRepository<Comic, Long> {

    Optional<Comic> findByName(String name);

    Optional<Comic> findById(Long Id);

    Optional<Comic> findByISBN(String ISBN);

    Optional<Comic> findByAuthor(String author);
}