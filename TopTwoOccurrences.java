package com.interview.solv;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem find top 2 most occurred strings in string array
 */
public class TopTwoOccurrences {
    public static void main(String[] args) throws IOException {

        String[] s = new String[]{"TPT", "MAS", "BLR", "BLR", "HYD", "BLR", "HYD"}; // String array

        Map<String, Integer> map = new HashMap<>(); // map for collecting occurrences

        for (String str : Arrays.asList(s)) {
            if (map.keySet().contains(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        List<Map.Entry<String, Integer>> li = new LinkedList<>(); // list of entities for collect entities in value order

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int i;
            for (i = 0; i < li.size(); i++) {
                if (li.get(i).getValue() < entry.getValue()) {
                    break;
                }
            }
            li.add(i, entry);
        }

        // IntStream for first 2 indexes
        System.out.println(IntStream.range(0, 2)
                .mapToObj(i -> li.get(i)).collect(Collectors.toList()));
    }
}
