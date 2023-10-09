package exceptions;

public class UnavailableBookException extends RuntimeException {
    public UnavailableBookException(String message) {
        super(message);
    }
}
