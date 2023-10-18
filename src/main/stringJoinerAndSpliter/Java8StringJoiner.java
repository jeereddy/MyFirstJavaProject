package main.stringJoinerAndSpliter;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Java8StringJoiner {
    public static void main(String[] args) {
        StringJoiner str1 = new StringJoiner("|");
        str1.add("hi");
        str1.add("hello");
        str1.add("US");
        System.out.println("String joiner with delimiter: " + str1);
        StringJoiner str2 = new StringJoiner(",", "[", "]");
        str2.add("hi");
        str2.add("hello");
        str2.add("US");
        System.out.println("String Joiner with delimiter prefix and suffix: " + str2);
        String str3 = String.join(",", "hi", "hello", "USA");
        System.out.println("String joined with join method: " + str3);
        String[] strArr = new String[]{"hi", "hello", "USA"};
        String str4 = String.join("/", strArr);
        System.out.println("String joined with join method: " + str4);
        List<String> strList = Arrays.asList("hi", "hello", "USA");
        String str5 = String.join("-", strList);
        System.out.println("String joined with join method: " + str5);
        String str6 = strList.stream().collect(Collectors.joining());
        System.out.println("String joined with Collectors joining method: " + str6);
        String str7 = strList.stream().collect(Collectors.joining("_"));
        System.out.println("String joined with Collectors joining method along with delimiter: " + str7);
        String str8 = strList.stream().collect(Collectors.joining("-", "[", "]"));
        System.out.println("String joined with Collectors joining method along with delimiter, prefix and sufix: " + str8);
    }
}
