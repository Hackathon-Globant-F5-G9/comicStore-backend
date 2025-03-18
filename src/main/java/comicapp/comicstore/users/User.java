package comicapp.comicstore.users;

import comicapp.comicstore.comics.Comic;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String surname;
    private String username;

    @ManyToOne
    @JoinColumn(name = "ISBN", nullable = false)
    private Comic myComics;

    @ManyToOne
    @JoinColumn(name = "ISBN", nullable = false)
    private Comic favourites;

    public User() {
    }

    public User(String name, String surname, String username) {
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public User(String name, Long id, String surname, String username, Comic myComics, Comic favourites) {
        this.name = name;
        this.id = id;
        this.surname = surname;
        this.username = username;
        this.myComics = myComics;
        this.favourites = favourites;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public Comic getMyComics() {
        return myComics;
    }

    public Comic getFavourites() {
        return favourites;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMyComics(Comic myComics) {
        this.myComics = myComics;
    }

    public void setFavourites(Comic favourites) {
        this.favourites = favourites;
    }

    public Long getId() {
        return id;
    }
}
