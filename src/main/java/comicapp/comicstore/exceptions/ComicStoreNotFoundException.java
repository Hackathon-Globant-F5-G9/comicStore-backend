package comicapp.comicstore.exceptions;

import comicapp.comicstore.users.User;

public class ComicStoreNotFoundException extends ComicStoreRuntimeException {
    public ComicStoreNotFoundException(String message) {
        super(message);
    }
}
