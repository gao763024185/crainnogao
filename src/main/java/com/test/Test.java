package com.test;

import java.util.Comparator;

public class Test {
    public static <T> T findMax(T[] arr, Comparator<? super T> cmp) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (cmp.compare(arr[i], arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    class CaseInsensitiveCompare implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            return lhs.compareToIgnoreCase(rhs);
        }
    }

    class TestProgram {
        public void main(String[] args) {
            String[] arr = {"ZEBRA", "alligator", "crocodile"};
            System.out.println(findMax(arr, new CaseInsensitiveCompare()));
        }
    }

}
