package comicapp.comicstore.comics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comics")
public class ComicController {
    private final ComicService comicService;

    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping
    public ResponseEntity<ComicResponseDTO> addComic(@RequestBody @Valid ComicRequestDTO comicRequestDTO){
        ComicResponseDTO comicResponseDTO = comicService.createComic(comicRequestDTO);
        return new ResponseEntity<>(comicResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ComicResponseDTO>> getAllComics(){
        List<ComicResponseDTO> comics = comicService.findAll();
        return new ResponseEntity<>(comics, HttpStatus.OK);
    }

    @GetMapping("/by-isbn/{ISBN}")
    public ResponseEntity<ComicResponseDTO> getComicByISBN(@PathVariable("ISBN") String ISBN){
        ComicResponseDTO comicResponseDTO = comicService.findByISBN(ISBN);
        return new ResponseEntity<>(comicResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<ComicResponseDTO> getComicById(@PathVariable Long id){
        ComicResponseDTO comicResponseDTO = comicService.findById(id);
        return new ResponseEntity<>(comicResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/by-isbn/{ISBN}")
    public ResponseEntity<ComicResponseDTO> updateAirport(@PathVariable String ISBN, @RequestBody @Valid ComicRequestDTO comicRequestDTO){
        ComicResponseDTO comicResponseDTO = comicService.updateComicByISBN(ISBN, comicRequestDTO);
        return new ResponseEntity<>(comicResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{ISBN}")
    public ResponseEntity<String> deleteComic(@PathVariable String ISBN){
        comicService.deleteComicByISBN(ISBN);
        return new ResponseEntity<>("The Comic has been eliminated", HttpStatus.OK);
    }

}
