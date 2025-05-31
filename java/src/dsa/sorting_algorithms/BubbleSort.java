package dsa.sorting_algorithms;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr){
        boolean swapped;
        for (int i = arr.length - 1; i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // O array já está ordenado
        }
        return arr;
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{1,2,3,4,5,6,7,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0,1});
    }
}
