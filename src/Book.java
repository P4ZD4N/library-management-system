import java.util.ArrayList;
import java.util.List;

abstract class Book implements MediaItem {
    private String title;
    private String author;
    private int publicationDate;
    private boolean availability;
    protected static List<String> listOfAvailableBooks = new ArrayList<>();
    protected static List<String> listOfBorrowedBooks = new ArrayList<>();

    protected Book(String title, String author, int publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.availability = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getPublicationDate() {
        return publicationDate;
    }

    @Override
    public boolean getAvailability() {
        return availability;
    }

    @Override
    public void borrowBook() {
        System.out.println("Book borrowed");
        availability = false;
        listOfAvailableBooks.remove(title);
        listOfBorrowedBooks.add(title);
    }

    @Override
    public void returnBook() {
        System.out.println("Book returned");
        availability = true;
        listOfAvailableBooks.add(title);
        listOfBorrowedBooks.add(title);
    }
}
