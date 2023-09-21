package app;

import java.util.ArrayList;
import java.util.List;

abstract class Book implements MediaItem {
    private String title;
    private String author;
    private int publicationDate;
    private boolean availability;
    private List<Object> bookData;
    protected static List<List<Object>> listOfAllBooks = new ArrayList<>();
    protected static List<Object> listOfAvailableBooks = new ArrayList<>();
    protected static List<Object> listOfBorrowedBooks = new ArrayList<>();
    protected static List<Object> historyOfBorrows = new ArrayList<>();

    protected Book(String title, String author, int publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.availability = true;

        bookData = List.of(title, author, publicationDate);

        listOfAllBooks.add(bookData);
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
        if (availability) {
            System.out.println("Book borrowed");
            availability = false;
            listOfAvailableBooks.remove(bookData);
            listOfBorrowedBooks.add(List.of(bookData, createBorrowerDataList(borrower)));
            historyOfBorrows.add(
                    List.of(
                            bookData, List.of(
                                    borrower.getFirstName(),
                                    borrower.getLastName(),
                                    borrower.getDateOfBirth(),
                                    borrower.getAddress(),
                                    borrower.getTelephone()
                            )
                    )
            );
        } else {
            System.out.println("Book is actually unavailable");
        }
    }

    @Override
    public void returnBook(Borrower borrower) {
        try {
            if (
                    listOfBorrowedBooks.contains(
                            listOfBorrowedBooks.get(
                                    listOfBorrowedBooks.indexOf(
                                            List.of(bookData, createBorrowerDataList(borrower))
                                    )
                            )
                    )
            ) {
                if (!availability) {
                    System.out.println("Book returned");
                    availability = true;
                    listOfBorrowedBooks.remove(List.of(bookData, createBorrowerDataList(borrower)));
                    listOfAvailableBooks.add(List.of(bookData));
                } else {
                    System.out.println("Book is actually not borrowed, so you can't return it");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This borrower didn't borrowed that book");
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
