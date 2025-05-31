package dsa.sorting_algorithms;

import java.util.Arrays;

public class MergeSort {
    public static int counter = 0;

    // Divide and Conquer
    public static int[] mergeSort(int[] arr){
        if(arr.length <= 1) return arr;

        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right){
        int i = 0, j = 0, z = 0;

        int[] merged = new int[left.length + right.length];

        while(i < left.length && j < right.length){
            if(left[i] >= right[j]){
                merged[z++] = right[j++];
            } else {
                merged[z++] = left[i++];
            }
        }

        while (i < left.length){
            merged[z++] = left[i++];
        }

        while (j < right.length){
            merged[z++] = right[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        mergeSort(new int[]{10,3,27,9,10,17,82,38,43});
        //merge(new int[]{3,27,38,43}, new int[]{9,10,17,82});
    }
}
