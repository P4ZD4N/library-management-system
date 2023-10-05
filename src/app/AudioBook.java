package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AudioBook extends Ebook {
    public AudioBook(String title, String author, int publicationDate) {
        super(title, author, publicationDate);
        listOfAvailableBooks.add(List.of(title, author, publicationDate));
    }

    public static List<Object> getListOfAvailableBooks() {
        return listOfAvailableBooks;
    }

    public static List<Object> getListOfBorrowedBooks() {
        return listOfBorrowedBooks;
    }

    public static List<List<Object>> getListOfAllBooks() {
        return listOfAllBooks;
    }

    public static List<List<Object>> getHistoryOfBorrows() {
        return historyOfBorrows;
    }

    public static List<Object> searchBookBy(String titleOrAuthor) {
        List<Object> booksFilteredByTitleOrAuthor = listOfAllBooks
                .stream()
                .filter(book -> book.contains(titleOrAuthor))
                .collect(Collectors.toList());
        return booksFilteredByTitleOrAuthor;
    }

    public static List<Object> searchBookBy(int publicationDate) {
        List<Object> booksFilteredByPublicationDate = listOfAllBooks
                .stream()
                .filter(book -> book.contains(publicationDate))
                .collect(Collectors.toList());
        return booksFilteredByPublicationDate;
    }
}
