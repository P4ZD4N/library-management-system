package app;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    private static List<List<Object>> listOfPhysicalBooks = PhysicalBook.getListOfAllBooks();
    private static List<List<Object>> listOfAudioBooks = AudioBook.getListOfAllBooks();
    private static List<List<Object>> listOfAllBooksBothPhysicalAndAudio = combineTwoLists(
            listOfPhysicalBooks, listOfAudioBooks
    );
    private static List<Object> historyOfBorrowsPhysicalBooks = PhysicalBook.getHistoryOfBorrows();
    private static List<Object> historyOfBorrowsAudioBooks = AudioBook.getHistoryOfBorrows();
    private static List<List<Object>> historyOfBorrowsAllBooks = combineTwoLists(
            historyOfBorrowsPhysicalBooks, historyOfBorrowsAudioBooks
    );

    public static List<String> getAuthorsWithMostAllBooks() {
        return createListContainingAuthorsWithMostBooks(listOfAllBooksBothPhysicalAndAudio);
    }
    public static List<String> getAuthorsWithMostPhysicalBooks() {
        return createListContainingAuthorsWithMostBooks(listOfPhysicalBooks);
    }
    public static List<String> getAuthorsWithMostAudioBooks() {
        return createListContainingAuthorsWithMostBooks(listOfAudioBooks);
    }
    public static List<Integer> getPublicationDatesMostAppearsAllBooks() {
        return createListContainingPublicationDatesMostAppearsInBooks(listOfAllBooksBothPhysicalAndAudio);
    }
    public static List<Integer> getPublicationDatesMostAppearsPhysicalBooks() {
        return createListContainingPublicationDatesMostAppearsInBooks(listOfPhysicalBooks);
    }
    public static List<Integer> getPublicationDatesMostAppearsAudioBooks() {
        return createListContainingPublicationDatesMostAppearsInBooks(listOfAudioBooks);
    }
    private static List<String> createListContainingAuthorsWithMostBooks(List<List<Object>> listOfBooks) {
        Set<String> authors = listOfBooks
                .stream()
                .map(bookProperties -> Objects.toString(bookProperties.get(1)))
                .collect(Collectors.toSet());
        Map<String, Integer> authorsWithOccurrences = createMapOfAuthorsAndNumberOfTheirBooksInLibrary(
                listOfBooks, authors
        );
        return createListOfAuthorsWithMostBooks(authorsWithOccurrences);
    }
    private static List<Integer> createListContainingPublicationDatesMostAppearsInBooks(List<List<Object>> listOfBooks) {
        Set<Integer> publicationDates = listOfBooks
                .stream()
                .map(bookProperties -> Integer.parseInt(Objects.toString(bookProperties.get(2))))
                .collect(Collectors.toSet());
        Map<Integer, Integer> datesOfPublicationWithOccurrences = createMapOfDatesOfPublicationAndNumberOfOccurrences(
                listOfBooks, publicationDates
        );
        return createListOfPublicationDatesMostAppearsInBooks(datesOfPublicationWithOccurrences);
    }
    private static <FirstList, SecondList> List<List<Object>> combineTwoLists(
            FirstList firstList, SecondList secondList
    ) {
        List<List<Object>> combinedList = new ArrayList<>();
        combinedList.addAll((Collection<? extends List<Object>>) firstList);
        combinedList.addAll((Collection<? extends List<Object>>) secondList);
        return combinedList;
    }
    private static Map<String, Integer> createMapOfAuthorsAndNumberOfTheirBooksInLibrary(
            List<List<Object>> listOfBooks, Set<String> listOfAuthors
    ) {
        Map<String, Integer> authorsAndNumberOfTheirBooksInLibrary = new HashMap<>();
        for (String author: listOfAuthors) {
            int booksOfThisAuthor = 0;
            for (List<Object> list: listOfBooks) {
                if (list.contains(author)) {
                    booksOfThisAuthor++;
                }
            }
            authorsAndNumberOfTheirBooksInLibrary.put(author, booksOfThisAuthor);
        }
        return authorsAndNumberOfTheirBooksInLibrary;
    }
    private static List<String> createListOfAuthorsWithMostBooks(Map<String, Integer> authorsAndNumberOfTheirBooksInLibrary) {
        List<String> authorsWithMostBooks = new ArrayList<>();
        for (String author: authorsAndNumberOfTheirBooksInLibrary.keySet()) {
            if (authorsAndNumberOfTheirBooksInLibrary.get(author).equals(Collections.max(
                    authorsAndNumberOfTheirBooksInLibrary.values()
            ))) {
                authorsWithMostBooks.add(author);
            }
        }
        return authorsWithMostBooks;
    }
    private static Map<Integer, Integer> createMapOfDatesOfPublicationAndNumberOfOccurrences(
            List<List<Object>> listOfBooks, Set<Integer> publicationDates
    ) {
        Map<Integer, Integer> datesOfPublicationAndNumberOfOccurrences = new HashMap<>();
        for (Integer publicationDate: publicationDates) {
            int booksWithThisPublicationDate = 0;
            for (List<Object> list: listOfBooks) {
                if (list.contains(publicationDate)) {
                    booksWithThisPublicationDate++;
                }
            }
            datesOfPublicationAndNumberOfOccurrences.put(publicationDate, booksWithThisPublicationDate);
        }
        return datesOfPublicationAndNumberOfOccurrences;
    }
    private static List<Integer> createListOfPublicationDatesMostAppearsInBooks(
            Map<Integer, Integer> datesOfPublicationAndNumberOfOccurrences
    ) {
        List<Integer> publicationDatesMostAppearsInBooks = new ArrayList<>();
        for (Integer publicationDate: datesOfPublicationAndNumberOfOccurrences.keySet()) {
            if (datesOfPublicationAndNumberOfOccurrences.get(publicationDate).equals(Collections.max(
                    datesOfPublicationAndNumberOfOccurrences.values()
            ))) {
                publicationDatesMostAppearsInBooks.add(publicationDate);
            }
        }
        return publicationDatesMostAppearsInBooks;
    }
}
