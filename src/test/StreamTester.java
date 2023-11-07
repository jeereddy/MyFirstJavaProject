package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {
        //Separate Odd and Even Number in given array
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 5, 13, 3, 4, 2, 15, 20);
        List<Integer> intList2 = Arrays.asList(1, 2, 3, 4, 5, 5, 3, 4, 2, 15, 20);
        List<String> stringArray = Arrays.asList("Join", "list", "of", "Strings", "with", "prefix", "sufix", "and", "delimiter");
        List<String> stringArray2 = Arrays.asList("Join", "list", "of", "Strings", "with", "prefix", "sufix", "and", "delimiter");
        evenOrOddIntegerSeparater(intList);
        //Remove duplicate from list
        removeDuplicatesFromList(intList);
        //Frequency of each char in given list
        frequencyOFEachChatInString("find frequency of each character in given string ");
        //Frequency of each element in array
        frequencyOfEachElementInArray(intList);
        //Reverse Order of given list
        reverseOrderOfList(intList);
        //Join List of strings with prefix sufix and delimiter
        joinListOfStrings(stringArray);
        //Print multiples of 5
        findMultiplesOfFive(intList);
        //Find min and max from the list
        findMinAndMaxInGivenList(intList);
        //Merge two unsorted arrays into one sorted array
        mergeTwoUnsortedArraysIntoSortedArray();
        //Two strings are anagram or not
        checkTwoStringsAnagram("RaceCar", "CarRace");
        //get Three Max And Min Values From list of int
        getThreeMaxAndMinValues(intList);
        //sum of all digits in number
        sumOfDigitsInNumber(1231234425);
        //Second largest number in given list
        secondMaxNumberInList(intList);
        //Sort list of strings based on string length
        sortStringListBasedOnLength(stringArray);
        //Common string between two list
        commonStringsBetweenList(stringArray, stringArray2);
        //sum and avg of elements in array
        sumAndAvgOfIntegerList(intList);
        //Reverse each word of paragraph
        reverseEachWordInParagraph("Hi Hello Srianth jeereddt");
    }

    private static void reverseEachWordInParagraph(String str) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" Reverse of each word in paragraph: " + Stream.of(str.split(" ")).
                map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" ")));
    }

    private static void sumAndAvgOfIntegerList(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(intList.stream().collect(Collectors.summarizingInt(Integer::intValue)));
    }

    private static void commonStringsBetweenList(List<String> stringArray, List<String> stringArray2) {
        System.out.println("-------------------------------------------------------------------------");
        stringArray.stream().filter(stringArray2::contains).forEach(System.out::println);
        System.out.println(stringArray.stream().filter(stringArray2::contains).toList());
        System.out.println(stringArray.contains("of"));
    }

    private static void sortStringListBasedOnLength(List<String> stringArray) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Sorted based on string length: " + stringArray.stream().sorted(Comparator.comparing(String::length)).toList());
        stringArray.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    private static void secondMaxNumberInList(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Second max number in list: " + intList.stream().sorted(Comparator.reverseOrder()).toList().get(1));
    }

    private static void sumOfDigitsInNumber(int i) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt)));
    }

    private static void getThreeMaxAndMinValues(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("first 3 min values: " + intList.stream().sorted(Comparator.comparing(Integer::intValue)).limit(3).toList());
        System.out.println("first 3 max values: " + intList.stream().sorted(Comparator.reverseOrder()).limit(3).toList());
    }

    private static void checkTwoStringsAnagram(String raceCar, String carRace) {
        System.out.println("-------------------------------------------------------------------------");
        String s1 = Stream.of(raceCar.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String s2 = Stream.of(carRace.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        System.out.println(s1);
        System.out.println(s2);
        if (s1.equals(s2)) {
            System.out.println("Two Strings are anagram");
        } else {
            System.out.println("Two Strings are not anagram");
        }
    }

    private static void mergeTwoUnsortedArraysIntoSortedArray() {
        System.out.println("-------------------------------------------------------------------------");
        int[] resultArray = IntStream.concat(Arrays.stream(new int[]{1, 2, 3, 4, 5, 2, 1, 4}), Arrays.stream(new int[]{1, 2, 3, 4, 5, 2, 1, 4})).sorted().toArray();
        System.out.println("Sorted merged array: " + Arrays.toString(resultArray));
    }

    private static void findMinAndMaxInGivenList(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(intList.stream().collect(Collectors.summarizingInt(Integer::intValue)));
        System.out.println("Min value in the given list: " + intList.stream().min(Comparator.comparingInt(Integer::intValue)).get());
        System.out.println("Min value in the given list: " + intList.stream().min(Comparator.naturalOrder()).get());
        System.out.println("Max value in the given list: " + intList.stream().max(Comparator.comparingInt(Integer::intValue)).get());
        System.out.println("Max value in the given list: " + intList.stream().max(Comparator.naturalOrder()).get());
    }

    private static void findMultiplesOfFive(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Multiples of 5: " + intList.stream().filter(i -> i % 5 == 0).toList());
    }

    private static void joinListOfStrings(List<String> stringArray) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(stringArray.stream().collect(Collectors.joining(" ", "$--", "--$")));
    }

    private static void reverseOrderOfList(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        intList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
    }

    private static void frequencyOfEachElementInArray(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        intList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(entry -> System.out.println("Element: " + entry.getKey() + " Frequency: " + entry.getValue()));
    }

    private static void frequencyOFEachChatInString(String str) {
        System.out.println("-------------------------------------------------------------------------");
        str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(entry -> System.out.println("Charector: " + entry.getKey() + " Frequency: " + entry.getValue()));
    }

    private static void removeDuplicatesFromList(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("List without duplicate values: " + intList.stream().distinct().toList());
    }

    private static void evenOrOddIntegerSeparater(List<Integer> intList) {
        System.out.println("-------------------------------------------------------------------------");
        intList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0)).entrySet().forEach(entry -> {
            if (!entry.getKey()) {
                System.out.println("All ODD numbers from given List: " + entry.getValue());
            } else {
                System.out.println("All EVEN numbers from given List: " + entry.getValue());
            }
        });
    }
}
