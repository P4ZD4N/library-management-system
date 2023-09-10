import java.util.List;

public class PhysicalBook extends Book {
    public PhysicalBook(String title, String author, int publicationDate) {
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
