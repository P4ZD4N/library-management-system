package app;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    private static List<List<Object>> listOfPhysicalBooks = PhysicalBook.getListOfAllBooks();
    private static List<List<Object>> listOfAudioBooks = AudioBook.getListOfAllBooks();
    private static List<List<Object>> listOfAllBooksBothPhysicalAndAudio = createListOfAllBooks(
            listOfPhysicalBooks, listOfAudioBooks
    );

    public static List<String> getMostPopularAuthor() {
        Set<String> allAuthors = listOfAllBooksBothPhysicalAndAudio
                .stream()
                .map(list -> Objects.toString(list.get(1)))
                .collect(Collectors.toSet());
        Map<String, Integer> authorsAndNumberOfTheirBooksInLibrary = createMapOfAuthorsAndNumberOfTheirBooksInLibrary(
                listOfAllBooksBothPhysicalAndAudio, allAuthors
        );
        List<String> mostPopularAuthors = createListOfMostPopularAuthors(authorsAndNumberOfTheirBooksInLibrary);
        return mostPopularAuthors;
    }
    public static List<String> getMostPopularAuthorPhysicalBooks() {
        Set<String> physicalBooksAuthors = listOfPhysicalBooks
                .stream()
                .map(list -> Objects.toString(list.get(1)))
                .collect(Collectors.toSet());
        Map<String, Integer> authorsAndNumberOfTheirBooksInLibrary = createMapOfAuthorsAndNumberOfTheirBooksInLibrary(
                listOfPhysicalBooks, physicalBooksAuthors
        );
        List<String> mostPopularAuthorsOfPhysicalBooks = createListOfMostPopularAuthors(authorsAndNumberOfTheirBooksInLibrary);
        return mostPopularAuthorsOfPhysicalBooks;
    }
    public static List<String> getMostPopularAuthorAudioBooks() {
        Set<String> audioBooksAuthors = listOfAudioBooks
                .stream()
                .map(list -> Objects.toString(list.get(1)))
                .collect(Collectors.toSet());
        Map<String, Integer> authorsAndNumberOfTheirBooksInLibrary = createMapOfAuthorsAndNumberOfTheirBooksInLibrary(
                listOfAudioBooks, audioBooksAuthors
        );
        List<String> mostPopularAuthorsOfAudioBooks = createListOfMostPopularAuthors(authorsAndNumberOfTheirBooksInLibrary);
        return mostPopularAuthorsOfAudioBooks;
    }
    public static List<Integer> getMostPopularPublicationDates() {
        Set<Integer> allPublicationDates = listOfAllBooksBothPhysicalAndAudio
                .stream()
                .map(list -> Integer.parseInt(Objects.toString(list.get(2))))
                .collect(Collectors.toSet());
        Map<Integer, Integer> datesOfPublicationAndNumberOfOccurrences = createMapOfDatesOfPublicationAndNumberOfOccurrences(
                listOfAllBooksBothPhysicalAndAudio, allPublicationDates
        );
        List<Integer> mostPopularPublicationDates = createListOfMostPopularPublicationDates(datesOfPublicationAndNumberOfOccurrences);
        return mostPopularPublicationDates;
    }
    public static List<Integer> getMostPopularPublicationDatesPhysicalBooks() {
        Set<Integer> physicalBooksPublicationDates = listOfPhysicalBooks
                .stream()
                .map(list -> Integer.parseInt(Objects.toString(list.get(2))))
                .collect(Collectors.toSet());
        Map<Integer, Integer> datesOfPublicationAndNumberOfOccurrences = createMapOfDatesOfPublicationAndNumberOfOccurrences(
                listOfPhysicalBooks, physicalBooksPublicationDates
        );
        List<Integer> mostPopularPublicationDatesOfPhysicalBooks = createListOfMostPopularPublicationDates(datesOfPublicationAndNumberOfOccurrences);
        return mostPopularPublicationDatesOfPhysicalBooks;
    }
    public static List<Integer> getMostPopularPublicationDatesAudioBooks() {
        Set<Integer> audioBooksPublicationDates = listOfAudioBooks
                .stream()
                .map(list -> Integer.parseInt(Objects.toString(list.get(2))))
                .collect(Collectors.toSet());
        Map<Integer, Integer> datesOfPublicationAndNumberOfOccurrences = createMapOfDatesOfPublicationAndNumberOfOccurrences(
                listOfAudioBooks, audioBooksPublicationDates
        );
        List<Integer> mostPopularPublicationDatesOfAudioBooks = createListOfMostPopularPublicationDates(datesOfPublicationAndNumberOfOccurrences);
        return mostPopularPublicationDatesOfAudioBooks;
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
            authorsAndNumberOfTheirBooksInLibrary.put(author, Integer.valueOf(booksOfThisAuthor));
        }
        return authorsAndNumberOfTheirBooksInLibrary;
    }
    private static List<String> createListOfMostPopularAuthors(Map<String, Integer> authorsAndNumberOfTheirBooksInLibrary) {
        List<String> mostPopularAuthors = new ArrayList<>();
        for (String author: authorsAndNumberOfTheirBooksInLibrary.keySet()) {
            if (authorsAndNumberOfTheirBooksInLibrary.get(author) == Collections.max(
                    authorsAndNumberOfTheirBooksInLibrary.values()
            )) {
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
            datesOfPublicationAndNumberOfOccurrences.put(publicationDate, Integer.valueOf(booksWithThisPublicationDate));
        }
        return datesOfPublicationAndNumberOfOccurrences;
    }
    private static List<Integer> createListOfMostPopularPublicationDates(
            Map<Integer, Integer> datesOfPublicationAndNumberOfOccurrences
    ) {
        List<Integer> mostPopularPublicationDates = new ArrayList<>();
        for (Integer publicationDate: datesOfPublicationAndNumberOfOccurrences.keySet()) {
            if (datesOfPublicationAndNumberOfOccurrences.get(publicationDate) == Collections.max(
                    datesOfPublicationAndNumberOfOccurrences.values()
            )) {
                mostPopularPublicationDates.add(publicationDate);
            }
        }
        return mostPopularPublicationDates;
    }
}
