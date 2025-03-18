package comicapp.comicstore.exceptions.globalhandler;

import comicapp.comicstore.exceptions.ComicStoreRuntimeException;

public class ComicStoreAlreadyExistsException extends RuntimeException {
    public ComicStoreAlreadyExistsException(String message) {
        super(message);
    }
}
