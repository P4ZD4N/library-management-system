package app;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Object> searchBookBy(String titleOrAuthor) {
        List<Object> booksFilteredByTitleOrAuthor = new ArrayList<>();
        for (List<Object> book: listOfAllBooks) {
            if (book.contains(titleOrAuthor)) {
                booksFilteredByTitleOrAuthor.add(book);
            }
        }
        return booksFilteredByTitleOrAuthor;
    }

    public static List<Object> searchBookBy(int publicationDate) {
        List<Object> booksFilteredByPublicationDate = new ArrayList<>();
        for (List<Object> book: listOfAllBooks) {
            if (book.contains(publicationDate)) {
                booksFilteredByPublicationDate.add(book);
            }
        }
        return booksFilteredByPublicationDate;
    }
}
