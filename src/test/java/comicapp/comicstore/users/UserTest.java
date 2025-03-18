package comicapp.comicstore.users;

import comicapp.comicstore.comics.Comic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testConstructorWithoutComics() {
        User user = new User("John", "Doe", "johndoe");

        assertEquals("John", user.getName());
        assertEquals("Doe", user.getSurname());
        assertEquals("johndoe", user.getUsername());
        assertNull(user.getMyComics());
        assertNull(user.getFavourites());
    }

    @Test
    void testConstructorWithComics() {
        Comic comic1 = new Comic();
        Comic comic2 = new Comic();
        User user = new User("John", 1L, "Doe", "johndoe", comic1, comic2);

        assertEquals("John", user.getName());
        assertEquals(1L, user.getId());
        assertEquals("Doe", user.getSurname());
        assertEquals("johndoe", user.getUsername());
        assertEquals(comic1, user.getMyComics());
        assertEquals(comic2, user.getFavourites());
    }

    @Test
    void testSettersAndGetters() {
        User user = new User();
        Comic comic1 = new Comic();
        Comic comic2 = new Comic();

        user.setName("Jane");
        user.setSurname("Smith");
        user.setUsername("janesmith");
        user.setMyComics(comic1);
        user.setFavourites(comic2);

        assertEquals("Jane", user.getName());
        assertEquals("Smith", user.getSurname());
        assertEquals("janesmith", user.getUsername());
        assertEquals(comic1, user.getMyComics());
        assertEquals(comic2, user.getFavourites());
    }
}