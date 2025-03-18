package comicapp.comicstore.comics;

import jakarta.persistence.*;

@Entity
@Table(name = "comics")
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ISBN", nullable = false, unique = true)
    private Long ISBN;

    private String name;
    private String author;
    private String editorial;
    private String genre;
    private String description;

    @Enumerated(EnumType.STRING)
    private State state;

    private float price;

    private String imageUrl;

    public Comic() {
    }

    public Comic(Long ISBN, String name, String author, String editorial, String genre, String description, State state,
            float price, String imageUrl) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.editorial = editorial;
        this.genre = genre;
        this.description = description;
        this.state = state;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public enum State {
        BOUGHT, NOT_BOUGHT
    }

    public Long getId() {
        return id;
    }

    public Long getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public State getState() {
        return state;
    }

    public float getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
