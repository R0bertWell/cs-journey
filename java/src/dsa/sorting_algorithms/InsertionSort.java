package dsa.sorting_algorithms;

public class InsertionSort {

    public static int[] insertionSort(int[] arr){


        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        return arr;
    }

    public static void main(String[] args) {
        insertionSort(new int[]{4,1,2,3,8,7,9,10, 1});
    }
}
