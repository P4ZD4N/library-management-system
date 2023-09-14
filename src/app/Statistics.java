package app;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    public static List<String> getMostPopularAuthor() {
        List<List<Object>> listOfAllBooksBothPhysicalAndAudio = new ArrayList<>();
        listOfAllBooksBothPhysicalAndAudio.addAll(PhysicalBook.getListOfAllBooks());
        listOfAllBooksBothPhysicalAndAudio.addAll(AudioBook.getListOfAllBooks());
        Set<String> allAuthors = listOfAllBooksBothPhysicalAndAudio.stream().map(list -> Objects.toString(list.get(1))).collect(Collectors.toSet());

        Map<String, Integer> authorsAndNumberOfTheirBooksInLibrary = new HashMap<>();

        for (String author: allAuthors) {
            int booksOfThisAuthor = 0;
            for (List<Object> list: listOfAllBooksBothPhysicalAndAudio) {
                if (list.contains(author)) {
                    booksOfThisAuthor++;
                }
            }
            authorsAndNumberOfTheirBooksInLibrary.put(author, Integer.valueOf(booksOfThisAuthor));
        }

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
//    public static String getMostPopularAuthorPhysicalBooks();
//    public static String getMostPopularAuthorAudioBooks();
//    public static String getMostPopularPublicationDate();
//    public static String getMostPopularPublicationDatePhysicalBooks();
//    public static String getMostPopularPublicationDateAudioBooks();
}
