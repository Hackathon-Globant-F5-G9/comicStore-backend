package comicapp.comicstore.comics;

import comicapp.comicstore.comics.Comic;
import comicapp.comicstore.exceptions.ComicStoreNotFoundException;
import comicapp.comicstore.exceptions.globalhandler.ComicStoreAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComicService {
    private final ComicRepository comicRepository;

    public ComicService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    public ComicResponseDTO createComic (ComicRequestDTO comicRequestDTO){
        if (comicRepository.findByISBN(comicRequestDTO.ISBN()).isPresent()){
            throw new ComicStoreAlreadyExistsException("An comic with this Code already exists");
        }
        Comic comic = ComicMapper.toEntity(comicRequestDTO);
        Comic savedComic = comicRepository.save(comic);
        return ComicMapper.toResponseDTO(savedComic);
    }

    public List<ComicResponseDTO> findAll(){
        List<Comic> comicList = comicRepository.findAll();
        return comicList.stream()
                .map(ComicMapper::toResponseDTO).toList();
    }

    public ComicResponseDTO findById(Long id){
        Optional<Comic> optionalComic = comicRepository.findById(id);

        if (optionalComic.isEmpty()){
            throw new ComicStoreNotFoundException("The Comic with the id " + id + "does not exist.");
        }

        Comic comic = optionalComic.get();
        return ComicMapper.toResponseDTO(comic);
    }

    public ComicResponseDTO findByISBN(String ISBN){
        Optional<Comic> optionalComic = comicRepository.findByISBN(ISBN);
        if(optionalComic.isEmpty()){
            throw new ComicStoreNotFoundException("There is no Comic with the ISBN" + ISBN + "does not exist");
        }

        Comic comic = optionalComic.get();
        return ComicMapper.toResponseDTO(comic);
    }
}
