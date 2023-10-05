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

    private static <T> List<List<Object>> combineTwoLists(T firstList, T secondList) {
        List<List<Object>> combinedList = new ArrayList<>();
        combinedList.addAll((Collection<? extends List<Object>>) firstList);
        combinedList.addAll((Collection<? extends List<Object>>) secondList);
        return combinedList;
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
    private static <T> Map<T, Integer> createMapOfElementsAndNumberOfItsOccurrences(
            List<List<Object>> listOfBooks, Set<T> set
    ) {
        Map<T, Integer> elementsAndNumberOfItsOccurrences = new HashMap<>();
        for (T elementOfSet: set) {
            int occurrences = 0;
            for (List<Object> list: listOfBooks) {
                if (list.contains(elementOfSet)) {
                    occurrences++;
                }
            }
            elementsAndNumberOfItsOccurrences.put(elementOfSet, occurrences);
        }
        return elementsAndNumberOfItsOccurrences;
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
}
