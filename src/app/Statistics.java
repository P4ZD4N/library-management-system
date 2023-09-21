package app;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    private static List<List<Object>> listOfPhysicalBooks = PhysicalBook.getListOfAllBooks();
    private static List<List<Object>> listOfAudioBooks = AudioBook.getListOfAllBooks();
    private static List<List<Object>> listOfAllBooksBothPhysicalAndAudio = createListOfAllBooks(
            listOfPhysicalBooks, listOfAudioBooks
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
    private static List<List<Object>> createListOfAllBooks(
            List<List<Object>> listOfPhysicalBooks, List<List<Object>> listOfAudioBooks
    ) {
        List<List<Object>> listOfAllBooksBothPhysicalAndAudio = new ArrayList<>();
        listOfAllBooksBothPhysicalAndAudio.addAll(listOfPhysicalBooks);
        listOfAllBooksBothPhysicalAndAudio.addAll(listOfAudioBooks);
        return listOfAllBooksBothPhysicalAndAudio;
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
        List<String> mostPopularAuthors = new ArrayList<>();
        for (String author: authorsAndNumberOfTheirBooksInLibrary.keySet()) {
            if (authorsAndNumberOfTheirBooksInLibrary.get(author).equals(Collections.max(
                    authorsAndNumberOfTheirBooksInLibrary.values()
            ))) {
                mostPopularAuthors.add(author);
            }
        }
        return mostPopularAuthors;
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
        List<Integer> mostPopularPublicationDates = new ArrayList<>();
        for (Integer publicationDate: datesOfPublicationAndNumberOfOccurrences.keySet()) {
            if (datesOfPublicationAndNumberOfOccurrences.get(publicationDate).equals(Collections.max(
                    datesOfPublicationAndNumberOfOccurrences.values()
            ))) {
                mostPopularPublicationDates.add(publicationDate);
            }
        }
        return mostPopularPublicationDates;
    }
}
