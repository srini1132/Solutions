package com.interview.solv;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem course dependency order
 * <p>
 * Here need to complete n(Ex: 10) courses new with course id as 1 to n
 * We need find the order of course to complete
 * Here we have dependency courses added in dependenceArray 0th index id depends on remaining
 * If has dependency for any course order should be dependency -> dependent
 * If has no dependency order is by course id
 */
public class DependentCourseOrder {
    public static void main(String[] args) {
        Integer courseCount = 10; // course count Ex: 10

        //Here fist index course id depend on remaining
        Integer[][] dependenceArray = new Integer[][]{{6, 7, 8}, {4, 5, 7}, {2, 6}, {1, 9, 10}};

        List<Integer> li = new LinkedList<>(); // result list

        for (int i = 1; i <= courseCount; i++) {
            if (!li.contains(i)) {
                li.add(i);
            }
            int j = li.indexOf(i);
            for (Integer[] arr : dependenceArray) {
                if (i == arr[0]) {
                    for (int k = 1; k < arr.length; k++) {
                        if (li.contains(arr[k])) {
                            li.remove(arr[k]);
                        }
                        li.add(j, arr[k]);
                        j++;
                    }
                }
            }
        }
        System.out.println(li); //output: [9, 10, 1, 7, 8, 6, 2, 3, 5, 4]
    }
}
