package app;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    private static List<List<Object>> listOfPhysicalBooks = PhysicalBook.getListOfAllBooks();
    private static List<List<Object>> listOfAudioBooks = AudioBook.getListOfAllBooks();
    private static List<List<Object>> listOfAllBooksBothPhysicalAndAudio = combineTwoLists(
            listOfPhysicalBooks, listOfAudioBooks
    );
    private static List<List<Object>> historyOfBorrowsPhysicalBooks = PhysicalBook.getHistoryOfBorrows();
    private static List<List<Object>> historyOfBorrowsAudioBooks = AudioBook.getHistoryOfBorrows();
    private static List<List<Object>> historyOfBorrowsAllBooks = combineTwoLists(
            historyOfBorrowsPhysicalBooks, historyOfBorrowsAudioBooks
    );

    public static List<String> getAuthorsWithMostAllBooks() {
        return getListOfElementsWithMostOccurrences(listOfAllBooksBothPhysicalAndAudio, 1);
    }
    public static List<String> getAuthorsWithMostPhysicalBooks() {
        return getListOfElementsWithMostOccurrences(listOfPhysicalBooks, 1);
    }
    public static List<String> getAuthorsWithMostAudioBooks() {
        return getListOfElementsWithMostOccurrences(listOfAudioBooks, 1);
    }
    public static List<Integer> getPublicationDatesMostAppearsAllBooks() {
        return getListOfElementsWithMostOccurrences(listOfAllBooksBothPhysicalAndAudio, 2);
    }
    public static List<Integer> getPublicationDatesMostAppearsPhysicalBooks() {
        return getListOfElementsWithMostOccurrences(listOfPhysicalBooks, 2);
    }
    public static List<Integer> getPublicationDatesMostAppearsAudioBooks() {
        return getListOfElementsWithMostOccurrences(listOfAudioBooks, 2);
    }
    public static List<String> getMostPopularAuthorsAllBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsAllBooks, 0, 1
        );
    }
    public static List<String> getMostPopularAuthorsPhysicalBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsPhysicalBooks, 0, 1
        );
    }
    public static List<String> getMostPopularAuthorsAudioBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsAudioBooks, 0, 1
        );
    }
    public static List<String> getMostPopularPublicationDatesAllBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsAllBooks, 0, 2
        );
    }
    public static List<String> getMostPopularPublicationDatesPhysicalBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsPhysicalBooks, 0, 2
        );
    }
    public static List<String> getMostPopularPublicationDatesAudioBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsAudioBooks, 0, 2
        );
    }
    public static List<String> getBorrowerWhoBorrowedLargestNumberOfAllBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsAllBooks, 1, 1
        );
    }
    public static List<String> getBorrowerWhoBorrowedLargestNumberOfPhysicalBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsPhysicalBooks, 1, 1
        );
    }
    public static List<String> getBorrowerWhoBorrowedLargestNumberOfAudioBooks() {
        return getListOfElementsWithMostOccurrences(
                historyOfBorrowsAudioBooks, 1, 1
        );
    }

    private static <T> List<T> getListOfElementsWithMostOccurrences(List<List<Object>> listOfBooks, int index) {
        Set<T> uniqueElements = listOfBooks
                .stream()
                .map(bookProperties -> (T) bookProperties.get(index))
                .collect(Collectors.toSet());
        Map<T, Integer> elementsWithOccurrences = createMapOfElementsAndNumberOfItsOccurrences(
                listOfBooks, uniqueElements
        );
        return createListOfElementsWithMostOccurrences(elementsWithOccurrences);
    }
    private static <T> List<T> getListOfElementsWithMostOccurrences(
            List<List<Object>> historyOfBorrows, int detailsOfBookOrBorrower, int detail
    ) {
        Set<T> uniqueElements = historyOfBorrows
                .stream()
                .map(bookAndBorrowerDetails -> ((List<T>)bookAndBorrowerDetails.get(detailsOfBookOrBorrower)).get(detail))
                .collect(Collectors.toSet());
        Map<T, Integer> elementsWithOccurrences = createMapOfElementsAndNumberOfItsOccurrences(
                historyOfBorrows, detailsOfBookOrBorrower, uniqueElements
        );
        return createListOfElementsWithMostOccurrences(elementsWithOccurrences);
    }
    private static <T> Map<T, Integer> createMapOfElementsAndNumberOfItsOccurrences(
            List<List<Object>> listOfBooks, Set<T> set
    ) {
        Map<T, Integer> elementsAndNumberOfItsOccurrences = new HashMap<>();
        for (T elementOfSet: set) {
            Long occurrences = new Long(listOfBooks
                    .stream()
                    .filter(list -> list.contains(elementOfSet))
                    .count()
            );
            elementsAndNumberOfItsOccurrences.put(elementOfSet, occurrences.intValue());
        }
        return elementsAndNumberOfItsOccurrences;
    }
    private static <T> Map<T, Integer> createMapOfElementsAndNumberOfItsOccurrences(
            List<List<Object>> historyOfBorrows, int detailsOfBookOrBorrower, Set<T> set
    ) {
        Map<T, Integer> elementsWithOccurrences = new HashMap<>();
        for (T elementOfSet: set) {
            Long occurrences = new Long(historyOfBorrows
                    .stream()
                    .filter(bookAndBorrowerDetails -> ((List<T>) bookAndBorrowerDetails.get(detailsOfBookOrBorrower)).contains(elementOfSet))
                    .count()
            );
            elementsWithOccurrences.put(elementOfSet, occurrences.intValue());
        }
        return elementsWithOccurrences;
    }
    private static <T> List<T> createListOfElementsWithMostOccurrences(
            Map<T, Integer> elementsAndNumberOfItsOccurrences
    ) {
        List<T> elementsWithMostOccurrences = new ArrayList<>();
        for (T element: elementsAndNumberOfItsOccurrences.keySet()) {
            if (elementsAndNumberOfItsOccurrences.get(element).equals(Collections.max(
                    elementsAndNumberOfItsOccurrences.values()
            ))) {
                elementsWithMostOccurrences.add(element);
            }
        }
        return elementsWithMostOccurrences;
    }
    private static <T> List<List<Object>> combineTwoLists(T firstList, T secondList) {
        List<List<Object>> combinedList = new ArrayList<>();
        combinedList.addAll((Collection<? extends List<Object>>) firstList);
        combinedList.addAll((Collection<? extends List<Object>>) secondList);
        return combinedList;
    }
}
