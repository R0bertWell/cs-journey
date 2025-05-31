package dsa.sorting_algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static int[] qs(int[] arr) {
        if(arr.length == 0) return new int[]{};

        int pivotIndex = (arr.length - 1) / 2;
        int pivot = arr[pivotIndex];

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == pivotIndex) continue;
            if (arr[i] < pivot) {
                left.add(arr[i]);
            } else {
                right.add(arr[i]);
            }
        }

        int[] leftSorted = qs(left.stream().mapToInt(Integer::intValue).toArray());
        int[] rightSorted = qs(right.stream().mapToInt(Integer::intValue).toArray());

        return concatenate(leftSorted, new int[]{pivot}, rightSorted);
    }

    private static int[] concatenate(int[]... arrays) {
        int totalLength = Arrays.stream(arrays).mapToInt(a -> a.length).sum();
        int[] result = new int[totalLength];
        int index = 0;
        for (int[] array : arrays) {
            for (int num : array) {
                result[index++] = num;
            }
        }
        return result;
    }
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(qs(new int[]{1, 2, 3, -4, -3, 20, 10, -5, 0})));
        System.out.println(Arrays.toString(qs(new int[]{2, 2, 2, 2, 2, 2, 2, 1, 2})));

    }
}
