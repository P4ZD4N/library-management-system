package app;

public interface MediaItem {
    String getTitle();
    String getAuthor();
    int getPublicationDate();
    boolean getAvailability();
    void borrowBook(Borrower borrower);
    void returnBook();
}
