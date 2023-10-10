# Description

Library management system app was supposed to be a project, that allow me to practise my OOP skills in Java. But finally, except OOP concepts like abstraction, polymorphism, inheritance and encapsulation I learnt a lot of new things and created first larger project than other so far. At this point, I think that I completed this project as best as I can.

# Abilities

- Adding new books (both physical and audiobooks) to the library.
- Borrowing and returning books. When book is borrowed or returned then availability of this book is updated.
- Displaying list of available books and borrowed books.
- Displaying history of borrows.
- Searching books by author, title and publication date.
- Storing informations about borrowers including:
  - First name (String),
  - Last name (String),
  - Date of birsth (LocalDate),
  - Address (String),
  - Telephone (String).
- Creating statistics including:
  - Authors, whose number of all books (both physical and audio) in library is the largest.
  - Authors, whose number of physical books in library is the largest.
  - Authors, whose number of audiobooks in library is the largest.
  - Publication dates, which appears the most in all books (both physical and audio).
  - Publication dates, which appears the most in physical books.
  - Publication dates, which appears the most in audiobooks.
  - Most popular all books (both physical and audio).
  - Most popular physical books.
  - Most popular audiobooks.
  - Most popular authors in all books (both physical and audio).
  - Most popular authors in physical books.
  - Most popular authors in audiobooks.
  - Most popular publication dates in all books (both physical and audio).
  - Most popular publication dates in physical books.
  - Most popular publication dates in audiobooks.
  - Borrowers, who borrowed largest number of all books (both physical and audio).
  - Borrowers, who borrowed largest number of physical books.
  - Borrowers, who borrowed largest number of audiobooks.

# Description of methods

### MediaItem interface
- <b>getTitle()</b> - Abstract method, which returns title of book (String).
- <b>getAuthor()</b> - Abstract method, which returns author of book (String).
- <b>getPublicationDate()</b> - Abstract method, which returns publication date of book (int).
- <b>getAvailability()</b> - Abstract method, which returns availability of book (boolean).
- <b>borrowBook(Borrower borrower)</b> - Abstract method, which causes borrowing book. When you use this method book is moving from list  <b>listOfAvailableBooks</b> to list <b>listOfBorrowedBooks</b>. Method require object of Borrower class as an argument to store contact data of borrower in listOfBorrowedBooks (void).
- <b>returnBook(Borrower borrower)</b> - Abstract method which causes returning book. When you use this method book is moving from list  <b>listOfBorrowedBooks</b> to list <b>listOfAvailableBooks</b>. Method require object of Borrower class as an argument  to delete contact data of borrower from listOfBorrowedBooks (void).

### Borrower class
- Getters and setters, which allows getting value of private variables storing data and setting new values.
- <b>Borrower()</b> - Constructor of Borrower class objects. It requires contact data of borrower as arguments including  first name, last name, date of birth, address and telephone.
- <b>getListOfBorrowers()</b> - Static method, which returns <b>listOfBorrowers</b> list. This list contains other lists,  
  that contains contact data of borrowers (List).

### Statistics class
- <b>getAuthorsWithMostAllBooks()</b> - Static method, which returns list of authors, whose library has the most books (from both physical books  and audiobooks) (List).
- <b>getAuthorsWithMostPhysicalBooks()</b> - Static method, which returns list of authors, whose library has the most  physical books (List).
- <b>getAuthorsWithMostAudioBooks()</b> - Static method, which returns list of authors, whose library has the most  audiobooks (List).
- <b>getPublicationDatesMostAppearsAllBooks()</b> - Static method, which returns list of publication dates that most  often occurs in books in the library (from both physical books and audiobooks) (List).
- <b>getPublicationDatesMostAppearsPhysicalBooks()</b> - Static method, which returns list of publication dates that most  often occurs in physical books in the library (List).
- <b>getPublicationDatesMostAppearsAudioBooks()</b> - Static method, which returns list of publication dates that most  often occurs in audiobooks in the library (List).
- <b>getMostPopularBooks()</b> - Static method, which returns list of most popular books, in other words books, which was borrowed most often (both physical and audio) (List)
- <b>getMostPopularPhysicalBooks()</b> - Static method, which returns list of most popular physical books, in other words physical books, which was borrowed most often (List)
- <b>getMostPopularAudioBooks()</b> - Static method, which returns list of most popular audiobooks, in other words audiobooks, which was borrowed most often (List) (List)
- <b>getMostPopularAuthorsAllBooks()</b> - Static method, which returns list of most popular authors in all borrowed books, in other words authors, whose books (both physical and audio) was borrowed most often. (List)
- <b>getMostPopularAuthorsPhysicalBooks()</b> - Static method, which returns list of most popular authors in borrowed physical books, in other words authors, whose physical books was borrowed most often. (List)
- <b>getMostPopularAuthorsAudioBooks()</b> - Static method, which returns list of most popular authors in borrowed audiobooks, in other words authors, whose audiobooks was borrowed most often. (List)
- <b>getMostPopularPublicationDatesAllBooks()</b> - Static method, which returns list of most popular publication dates in all borrowed books, in other words publication dates, which appears most often in all borrowed books (both physical and audio). (List)
- <b>getMostPopularPublicationDatesPhysicalBooks()</b> - Static method, which returns list of most popular publication dates in borrowed physical books, in other words publication dates, which appears most often in borrowed physical books. (List)
- <b>getMostPopularPublicationDatesAudioBooks()</b> - Static method, which returns list of most popular publication dates in borrowed audiobooks, in other words publication dates, which appears most often in borrowed audiobooks. (List)
- <b>getBorrowerWhoBorrowedLargestNumberOfAllBooks()</b> - Static method, which returns list of borrowers, who borrowed largest number of all books (both physical and audio). (List)
- <b>getBorrowerWhoBorrowedLargestNumberOfPhysicalBooks()</b> - Static method, which returns list of borrowers, who borrowed largest number of physical books. (List)
- <b>getBorrowerWhoBorrowedLargestNumberOfAudioBooks()</b> - Static method, which returns list of borrowers, who borrowed largest number of audiobooks. (List)
- <b>getListOfElementsWithMostOccurrences(List<List<Object\>> listOfBooks, int detail)</b> - Static overloaded method, which returns list of elements with most occurrences. Method require two arguments: <b>listOfBooks</b> and <b>detail</b>.
  - As first argument <b>you should enter list</b> of specified type of books (e.g. list of audiobooks).
  - As second argument <b>you should enter one of two integers</b>: <b>1</b> (then method will return list of authors, which most often appears in list entered as first argument) or <b>2</b> (then method will return list of publication dates, which most often appears in list entered as first argument). (List)
- <b>getListOfElementsWithMostOccurrences(List<List<Object\>> listOfBooks, int detailsOfBookOrBorrower, int detail)</b> - Static overloaded method, which returns list of elements with most occurrences. Method require three arguments: <b>historyOfBorrows</b>, <b>detailsOfBookOrBorrower</b> and <b>detail</b>.
  - As first argument <b>you should enter list</b>, which stores history of specified type of books borrows (e.g. history of audiobooks borrows).
  - As second argument <b>you should enter one of two integers</b>: <b>0</b> (then you will search desired element in book details) or <b>1</b> (then you will search desired element in borrower of book details).
  - As third argument if you entered as second argument:
    - <b>0: you should enter one of three integers</b>: <b>0</b> (then method will return list of titles, which appears most often in list entered as first argument and then in second argument), <b>1</b> (then method will return list of authors, which appears most often in list entered as first argument and then in second argument) or <b>2</b> (then method will return list of publication dates, which appears most often in list entered as first argument and then in second argument). (List)
    - <b>1: you should enter 1</b>, then method will return list of last names of borrowers, which appears most often in list entered as first argument and then in second argument. (List)
- <b>createMapOfElementsAndNumberOfItsOccurrences(List<List<Object\>> listOfBooks, Set<T\> set)</b> - Static overloaded method, which returns map of elements as keys and number of their occurrences as values. Method require two arguments: <b>listOfBooks</b> and <b>set</b>.
  - As first argument <b>you should enter list</b> of specified type of books (e.g. list of audiobooks).
  - As second argument <b>you should enter set</b> of unique elements. Method will count occurrences of these elements in list entered as first argument.
- <b>createMapOfElementsAndNumberOfItsOccurrences(List<List<Object\>> listOfBooks, int detailsOfBookOrBorrower, Set<T\> set)</b> - Static overloaded method, which returns map of elements as keys and number of their occurrences as values. Method require two arguments: <b>listOfBooks</b> and <b>set</b>.
  - As first argument <b>you should enter list</b> of specified type of books (e.g. list of audiobooks).
  - As second argument <b>you should enter one of two integers</b>: <b>0</b> (then you will search desired element in book details) or <b>1</b> (then you will search desired element in borrower of book details).
  - As third argument <b>you should enter set</b> of unique elements. Method will count occurrences of these elements in list entered as first argument.
- <b>createListOfElementsWithMostOccurrences(Map<T, Integer> elementsAndNumberOfItsOccurrences)</b> - Static method, which returns list of elements with most occurrences.
- <b>combineTwoLists(T firstList, T secondList)</b> - Static method, which returns combination of two lists entered as arguments. Both lists must be of the same type. (List)

### Book abstract class and Ebook abstract class
- Both classes implements <b>MediaItem</b> interface, so they inherit all methods from it.
- <b>Book() and Ebook()</b> - Constructors of Ebook and Book class objects. It requires data about book as arguments including  title, author and publication date.
- <b>createBorrowerDataList()</b> - Private method, which creates and returns list of data of borrower.

### PhysicalBook class and AudioBook class
- Class PhysicalBook extends <b>Book</b> abstract class, so it inherit all non-private methods and variables from it.
- Class AudioBook extends <b>Ebook</b> abstract class, so it inherit all non-private methods and variables.
- <b>getListOfAvailableBooks()</b> - Static method, which returns <b>listOfAvailableBooks</b> list (List).
- <b>getListOfBorrowedBooks()</b> - Static method, which returns <b>listOfBorrowedBooks</b> list (List).
- <b>getListOfAllBooks()</b> - Static method, which returns <b>listOfAllBooks</b> list (List).
- <b>searchBookBy(String arg)</b> - Static method, which returns list of books filtered by title or author (List).
- <b>searchBookBy(int arg)</b> - Static method, which returns list of books filtered by publication date (List).

# Custom exceptions
- <b>NotBorrowedBookException</b> - Custom runtime exception, which must be thrown, when borrower would like to return book, which he didn't borrowed.
- <b>UnavailableBookException</b> - Custom runtime exception, which must be thrown, when borrower would like to borrow book, which he is actually unavailable.

# Plans
- Custom exceptions in Statistics class.
- Improve this readme.