package app;

import java.util.List;

public class AudioBook extends Ebook {
    public AudioBook(String title, String author, int publicationDate) {
        super(title, author, publicationDate);
        listOfAvailableBooks.add(title);
    }

    public static List<String> getListOfAvailableBooks() {
        return listOfAvailableBooks;
    }

    public static List<String> getListOfBorrowedBooks() {
        return listOfBorrowedBooks;
    }
}
