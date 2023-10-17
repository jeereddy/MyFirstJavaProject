package test;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class JavaSpliteratorTester {
    /*Enumeration, Iterator and ListIterator – till Java 7, these three iterators are available in Java.
    From Java 8, Spliterator is added to this group of iterators. As the name itself suggest,
    Spliterator performs partitioning as well as iterating. It is most suitable for parallel programming.
    Using old Iterators, you can iterate only collection types. But, Spliterator can be used to iterate
    collections, arrays and streams. */
    public static void main(String[] args) {
        // Spliterator form array
        String[] LangArray = new String[]{"hello", "hi"};
        Spliterator<String> arraySpliterator = Arrays.spliterator(LangArray);
        //Spliterator for a List
        List<String> langList = Arrays.asList("Hello", "Hi");
        Spliterator<String> listSpliterator = langList.spliterator();
        //Spliterator from a Stream
        Stream<String> langStream = Stream.of("hello", "hi", "Stream Api");
        Spliterator<String> streamSpliterator = langStream.spliterator();

        arraySpliterator.tryAdvance(System.out::println);
        listSpliterator.tryAdvance(System.out::println);
        streamSpliterator.tryAdvance(System.out::println);
        streamSpliterator.forEachRemaining(System.out::println);
    }
}
