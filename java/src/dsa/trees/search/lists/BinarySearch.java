package dsa.trees.search.lists;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1; // 10 itens = index to 9
        while(left <= right){
            int middle = (left + right)/2; // middle is (left + right) / 2 = 0+9 / 2 = 4.5 (4)
            if(arr[middle] == target) return middle;

            if(arr[middle] < target) left = middle + 1;
            else if(arr[middle] > target) right = middle - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int tar = 7;
        System.out.println("Search INDEX => " + search(arr, 1));
    }
}
