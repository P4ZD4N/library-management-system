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
- Storing informations about borrowers, including contact data. <b>[IN PLANS]</b>
- Creating statistics about e.g. books or authors popularity. <b>[IN PLANS]</b>

# Description of methods

### MediaItem interface
- <b>getTitle()</b> - Method, which returns title of book (String).
- <b>getAuthor()</b> - Method, which returns author of book (String).
- <b>getPublicationDate()</b> - Method, which returns publication date of book (int).
- <b>getAvailability()</b> - Method, which returns availability of book (boolean).
- <b>borrowBook()</b> - Method, which causes borrowing book. When you use this method book is moving from list 
<b>listOfAvailableBooks</b> to list <b>listOfBorrowedBooks</b> 
- <b>returnBook()</b> - Method which causes returning book. When you use this method book is moving from list
<b>listOfBorrowedBooks</b> to list <b>listOfAvailableBooks</b> 

### Book abstract class and Ebook abstract class
- Both classes implements <b>MediaItem</b> interface, so they inherit all methods from it.

### PhysicalBook class and AudioBook class
- Class PhysicalBook extends <b>Book</b> abstract class, so it inherit all non-private methods and variables from it.
- Class AudioBook extends <b>Ebook</b> abstract class, so it inherit all non-private methods and variables.
- <b>getListOfAvailableBooks()</b> - Static method, which returns <b>listOfAvailableBooks</b> list (List).
- <b>getListOfBorrowedBooks()</b> - Static method, which returns <b>listOfBorrowedBooks</b> list (List).
- <b>searchBookBy(String arg)</b> - Static method, which returns list of books filtered by title or author (List).
- <b>searchBookBy(int arg)</b> - Static method, which returns list of books filtered by publication date (List).
