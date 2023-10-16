package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamApi {
    public static void main(String[] args) {
        List<Integer> intArr1 = Arrays.asList(1, 2, 2, 4, 3, 5, 6, 7, 8, 9, 3);
        System.out.println(intArr1);
        List<Integer> intArr2 = intArr1.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(intArr2);
        System.out.println("Count of int values in given array: " + intArr2.stream().count());
        int sumofEvenNumbers = intArr1.stream()
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("sum of even numbers: " + sumofEvenNumbers);

    }
}
