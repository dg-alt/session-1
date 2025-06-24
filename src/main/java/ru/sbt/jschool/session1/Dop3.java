package ru.sbt.jschool.session1;

import java.util.*;
import java.util.stream.*;

public class Dop3 {
    public static long[] intersection(long[] arr1, long[] arr2) {
        Set<Long> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        return Arrays.stream(arr2)
                .filter(set::contains)
                .distinct()
                .toArray();
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ru.sbt.jschool.session1.Dop3 \"1,2,3\" \"2,3,4\"");
            return;
        }

        System.out.println("Input arrays:");
        System.out.println("Array 1: " + args[0]);
        System.out.println("Array 2: " + args[1]);

        long[] arr1 = parseArray(args[0]);
        long[] arr2 = parseArray(args[1]);
        long[] result = intersection(arr1, arr2);

        System.out.println("Intersection: " + Arrays.toString(result));
    }

    private static long[] parseArray(String s) {
        return Arrays.stream(s.split(","))
                .map(String::trim)
                .mapToLong(Long::parseLong)
                .toArray();
    }
}