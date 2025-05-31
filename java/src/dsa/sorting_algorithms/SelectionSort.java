package dsa.sorting_algorithms;

public class SelectionSort {

    public static int[] selectionSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            int minIndex = i;

            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            if(i != minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        selectionSort(new int[]{4,1,2,3,8,7,9,10,11,1,1,1,1,1,1,1,1,1,0,1});

    }
}
