package dsa.sorting_algorithms.visualization.merge;

import java.util.Arrays;

public class MergeSortConsoleVisualizer {

    private static int depth = 0;

    public static int[] mergeSort(int[] arr, String label) {
        printIndented("Dividindo [" + label + "]: " + Arrays.toString(arr));

        if (arr.length <= 1) {
            printIndented("Retornando [" + label + "]: " + Arrays.toString(arr));
            return arr;
        }

        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        depth++;
        int[] sortedLeft = mergeSort(left, label + "-L");
        int[] sortedRight = mergeSort(right, label + "-R");
        depth--;

        int[] merged = merge(sortedLeft, sortedRight, label);
        printIndented("Resultado mesclado [" + label + "]: " + Arrays.toString(merged));
        return merged;
    }

    private static int[] merge(int[] left, int[] right, String label) {
        printIndented("Mesclando [" + label + "]: " + Arrays.toString(left) + " + " + Arrays.toString(right));
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }

    private static void printIndented(String message) {
        for (int i = 0; i < depth; i++) System.out.print("  ");
        System.out.println(message);
    }

    public static void main(String[] args) {
        int[] input = {10, 3, 27, 9, 10, 17, 82, 38, 43};
        System.out.println("Array inicial: " + Arrays.toString(input));
        System.out.println("\n======= Iniciando Merge Sort =======\n");
        int[] sorted = mergeSort(input, "ROOT");

        System.out.println("\n======= Resultado Final =======");
        System.out.println("Array ordenado: " + Arrays.toString(sorted));
    }
}