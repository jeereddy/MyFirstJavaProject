package main.stringJoinerAndSpliter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StringSpliter {
    public static void main(String[] args) {
        // Split paragraph in to list of string and remove the string from list if exist more than once
        String str = "The word \"technology\" and its uses have immensely changed since the 20th century, and with time, it has continued to evolve ever since. We are living in a world driven by technology. The advancement of technology has played an important role in the development of human civilization, along with cultural changes. Technology provides innovative ways of doing work through various smart and innovative means.";
        String[] strArr = str.split("[^a-zA-Z0-9]+");
        String[] strArr2 = str.split(" ");
        // System.out.println(Arrays.stream(strArr).collect(Collectors.toList()));
        // System.out.println(Arrays.stream(strArr2).collect(Collectors.toList()));
        Arrays.stream(strArr).collect(Collectors.groupingBy(String::valueOf)).entrySet().removeIf(entry -> entry.getValue().size() > 1);
        Map<String, Long> resp = Arrays.stream(strArr).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        resp.entrySet().forEach(entry -> System.out.print(entry.getKey() + ": " + entry.getValue() + " "));
        resp.entrySet().removeIf(entry -> entry.getValue() > 1);
        System.out.println();
        resp.entrySet().forEach(entry -> System.out.print(entry.getKey() + ": " + entry.getValue() + " "));


    }
}
