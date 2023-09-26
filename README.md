# Description

Library management system app, which helped me practise my OOP skills in Java. It uses: 
- Abstraction, 
- Polymorphism, 
- Encapsulation, 
- Inheritance.

# Abilities

- Adding new books (both physical and audiobooks) to the library.
- Borrowing and returning books. When book is borrowed or returned then availability of this book is updated.
- Displaying list of available books and borrowed books.
- Searching books by author, title and publication date.
- Storing informations about borrowers including:
  - First name (String),
  - Last name (String),
  - Date of birsth (LocalDate),
  - Address (String),
  - Telephone (String).
- Creating statistics.
  - Authors, whose number of all books (both physical and audio) in library is the largest.
  - Authors, whose number of physical books in library is the largest.
  - Authors, whose number of audiobooks in library is the largest.
  - Publication dates, which appears the most in all books (both physical and audio).
  - Publication dates, which appears the most in physical books.
  - Publication dates, which appears the most in audiobooks.

# Description of methods

### MediaItem interface
- <b>getTitle()</b> - Method, which returns title of book (String).
- <b>getAuthor()</b> - Method, which returns author of book (String).
- <b>getPublicationDate()</b> - Method, which returns publication date of book (int).
- <b>getAvailability()</b> - Method, which returns availability of book (boolean).
- <b>borrowBook(Borrower borrower)</b> - Method, which causes borrowing book. When you use this method book is moving from list 
<b>listOfAvailableBooks</b> to list <b>listOfBorrowedBooks</b>. Method require object of Borrower class as an argument
to store contact data of borrower in listOfBorrowedBooks (void).
- <b>returnBook(Borrower borrower)</b> - Method which causes returning book. When you use this method book is moving from list
<b>listOfBorrowedBooks</b> to list <b>listOfAvailableBooks</b>. Method require object of Borrower class as an argument 
to delete contact data of borrower from listOfBorrowedBooks (void).

### Borrower class
- Getters and setters, which allows getting value of private variables storing data and setting new values.
- <b>Borrower()</b> - Constructor of Borrower class objects. It requires contact data of borrower as arguments including
first name, last name, date of birth, address and telephone.
- <b>getListOfBorrowers()</b> - Static method, which returns <b>listOfBorrowers</b> list. This list contains other lists,
that contains contact data of borrowers (List).

### Statistics class
- <b>getAuthorsWithMostAllBooks()</b> - Static method, which returns list of authors, whose library has the most books (from both physical books
and audiobooks) (List).
- <b>getAuthorsWithMostPhysicalBooks()</b> - Static method, which returns list of authors, whose library has the most 
physical books (List).
- <b>getAuthorsWithMostAudioBooks()</b> - Static method, which returns list of authors, whose library has the most
  audiobooks (List).
- <b>getPublicationDatesMostAppearsAllBooks()</b> - Static method, which returns list of publication dates that most
often occurs in books in the library (from both physical books and audiobooks) (List).
- <b>getPublicationDatesMostAppearsPhysicalBooks()</b> - Static method, which returns list of publication dates that most
  often occurs in physical books in the library (List).
- <b>getPublicationDatesMostAppearsAudioBooks()</b> - Static method, which returns list of publication dates that most
  often occurs in audiobooks in the library (List).
- <b>createListContainingAuthorsWithMostBooks()</b> - Private static method, which returns list of strings. It is 
important method, which creates list of authors with most books in library depending on list, which we would enter as an
argument.
- <b>createListContainingPublicationDatesMostAppearsInBooks()</b> - Private static method, which returns list of integers. It is
  important method, which creates list of publication dates, mostly occurs in books depending on list, which we would
enter as an argument.
- <b>createListOfAllBooks()</b> - Private static method, which returns list combined of two lists entered as an
arguments.
- <b>createMapOfAuthorsAndNumberOfTheirBooksInLibrary()</b> - Private static method, which returns map with strings (authors) as keys
and integers (number of books of author) as values.
- <b>createListOfAuthorsWithMostBooks()</b> - Private static method, which returns list of authors with most books.
- <b>createMapOfDatesOfPublicationAndNumberOfOccurrences()</b> - Private static method, which returns map with integers 
(publication dates) as keys and integers (number of books with this publication date) as values.
- <b>createListOfPublicationDatesMostAppearsInBooks()</b> - Private static method, which returns list of publication dates 
which occurs the most in books.

### Book abstract class and Ebook abstract class
- Both classes implements <b>MediaItem</b> interface, so they inherit all methods from it.
- <b>Book() and Ebook()</b> - Constructors of Ebook and Book class objects. It requires data about book as arguments including
  title, author and publication date.
- <b>createBorrowerDataList()</b> - Private method, which creates and returns list of data of borrower.

### PhysicalBook class and AudioBook class
- Class PhysicalBook extends <b>Book</b> abstract class, so it inherit all non-private methods and variables from it.
- Class AudioBook extends <b>Ebook</b> abstract class, so it inherit all non-private methods and variables.
- <b>getListOfAvailableBooks()</b> - Static method, which returns <b>listOfAvailableBooks</b> list (List).
- <b>getListOfBorrowedBooks()</b> - Static method, which returns <b>listOfBorrowedBooks</b> list (List).
- <b>getListOfAllBooks()</b> - Static method, which returns <b>listOfAllBooks</b> list (List).
- <b>searchBookBy(String arg)</b> - Static method, which returns list of books filtered by title or author (List).
- <b>searchBookBy(int arg)</b> - Static method, which returns list of books filtered by publication date (List).

# Plans
- New statistics incluging:
  - Most popular authors in all books.
  - Most popular authors in physical books.
  - Most popular authors in audio books.
  - Most popular publication dates in all books.
  - Most popular publication dates in physical books.
  - Most popular publication dates in audio books.
  - Borrowers, who borrowed largest number of all books.
  - Borrowers, who borrowed largest number of physical books.
  - Borrowers, who borrowed largest number of audio books.