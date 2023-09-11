package app;

import java.util.ArrayList;
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

    public static List<Object> searchBookBy(String titleOrAuthor) {
        List<Object> booksFilteredByTitleOrAuthor = new ArrayList<>();
        for (List<Object> book: listOfAllBooks) {
            if (book.contains(titleOrAuthor)) {
                booksFilteredByTitleOrAuthor.add(book);
            }
        }
        return booksFilteredByTitleOrAuthor;
    }

    public static List<Object> searchBookBy(int productionDate) {
        List<Object> booksFilteredByProductionDate = new ArrayList<>();
        for (List<Object> book: listOfAllBooks) {
            if (book.contains(productionDate)) {
                booksFilteredByProductionDate.add(book);
            }
        }
        return booksFilteredByProductionDate;
    }
}
