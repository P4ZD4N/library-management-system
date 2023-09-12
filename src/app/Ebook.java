package app;

import java.util.ArrayList;
import java.util.List;

abstract class Ebook implements MediaItem {
    private String title;
    private String author;
    private int publicationDate;
    private boolean availability;
    protected static List<List<Object>> listOfAllBooks = new ArrayList<>();
    protected static List<String> listOfAvailableBooks = new ArrayList<>();
    protected static List<Object> listOfBorrowedBooks = new ArrayList<>();

    protected Ebook(String title, String author, int publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.availability = true;

        List<Object> bookProperties = new ArrayList<>();
        bookProperties.add(title);
        bookProperties.add(author);
        bookProperties.add(publicationDate);

        listOfAllBooks.add(bookProperties);
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
    public void borrowBook(Borrower borrower) {
        if (availability == true) {
            System.out.println("Book borrowed");
            availability = false;
            listOfAvailableBooks.remove(title);
            listOfBorrowedBooks.add(List.of(title, createBorrowerDataList(borrower)));
        } else {
            System.out.println("Book is actually unavailable");
        }
    }

    @Override
    public void returnBook(Borrower borrower) {
        if (availability == false) {
            System.out.println("Book returned");
            availability = true;
            listOfBorrowedBooks.remove(List.of(title, createBorrowerDataList(borrower)));
            listOfAvailableBooks.add(title);
        } else {
            System.out.println("Book is actually not borrowed, so you can't return it");
        }
    }

    private List<Object> createBorrowerDataList(Borrower borrower) {
        return List.of(
                borrower.getFirstName(),
                borrower.getLastName(),
                borrower.getDateOfBirth(),
                borrower.getAddress(),
                borrower.getTelephone()
        );
    }
}
