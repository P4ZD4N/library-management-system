package exceptions;

public class NotBorrowedBookException extends RuntimeException {
    public NotBorrowedBookException(String message) {
        super(message);
    }
}
