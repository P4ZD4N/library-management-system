# Description

Library management system app, which helped me practise my OOP skills in Java. It uses: 
- Abstraction, 
- Polymorphism, 
- Encapsulation, 
- Inheritance.

# Abilities

- Adding new books (both physical and e-books) to the library.
- Borrowing and returning books. When book is borrowed or returned then availability of this book is updated.
- Displaying list of available books and borrowed books.
- Searching books by author, title and publication date.
- Storing informations about borrowers, including contact data.
- Creating statistics about e.g. books or authors popularity. <b>[IN PLANS]</b>

# Description of methods

### MediaItem interface
- <b>getTitle()</b> - Method, which returns title of book (String).
- <b>getAuthor()</b> - Method, which returns author of book (String).
- <b>getPublicationDate()</b> - Method, which returns publication date of book (int).
- <b>getAvailability()</b> - Method, which returns availability of book (boolean).
- <b>borrowBook(Borrower borrower)</b> - Method, which causes borrowing book. When you use this method book is moving from list 
<b>listOfAvailableBooks</b> to list <b>listOfBorrowedBooks</b>. Method require object of Borrower class as an argument
to store contact data of borrower in listOfBorrowedBooks.
- <b>returnBook(Borrower borrower)</b> - Method which causes returning book. When you use this method book is moving from list
<b>listOfBorrowedBooks</b> to list <b>listOfAvailableBooks</b>. Method require object of Borrower class as an argument 
to delete contact data of borrower from listOfBorrowedBooks.

### Borrower class
- Getters and setters, which allows getting value of private variables storing data and setting new values.
- <b>getListOfBorrowers()</b> - Static method, which returns <b>listOfBorrowers</b> list. This list contains other lists,
that contains contact data of borrowers (List).

### Statistics class
- <b>getMostPopularAuthor()</b> - Static method, which returns list of authors, whose library has the most books (from both physical books
and audiobooks) (List).
- <b>getMostPopularAuthorPhysicalBooks()</b> - Static method, which returns list of authors, whose library has the most 
physical books (List).
- <b>getMostPopularAuthorAudioBooks()</b> - Static method, which returns list of authors, whose library has the most
  audio books (List).
- <b>getMostPopularPublicationDates()</b> - Static method, which returns list of publication dates of books that most
often occurs in books in the library (from both physical books and audiobooks) (List).

### Book abstract class and Ebook abstract class
- Both classes implements <b>MediaItem</b> interface, so they inherit all methods from it.

### PhysicalBook class and AudioBook class
- Class PhysicalBook extends <b>Book</b> abstract class, so it inherit all non-private methods and variables from it.
- Class AudioBook extends <b>Ebook</b> abstract class, so it inherit all non-private methods and variables.
- <b>getListOfAvailableBooks()</b> - Static method, which returns <b>listOfAvailableBooks</b> list (List).
- <b>getListOfBorrowedBooks()</b> - Static method, which returns <b>listOfBorrowedBooks</b> list (List).
- <b>getListOfAllBooks()</b> - Static method, which returns <b>listOfAllBooks</b> list (List).
- <b>searchBookBy(String arg)</b> - Static method, which returns list of books filtered by title or author (List).
- <b>searchBookBy(int arg)</b> - Static method, which returns list of books filtered by publication date (List).
