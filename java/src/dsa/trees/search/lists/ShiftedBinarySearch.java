package dsa.trees.search.lists;

public class ShiftedBinarySearch {

    // O(2Logn) = O(Logn)

    public static int findPivo(int[] arr){
        int size = arr.length - 1;
        int left = 0, right = size;

        if (arr[left] < arr[right]) return -1;


        while(left <= right){
            int middle = (left + right) / 2;
            if(middle < size && arr[middle] > arr[middle + 1]) return middle;

            if (arr[middle] >= arr[left]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static int shiftSearchCorrect(int[] arr, int target) {
        int size = arr.length;
        if (size == 0) return -1;

        int pivo = findPivo(arr);

        int left = 0;
        int right = size -1;

        if(pivo == -1){
            return binarySearch(arr, target, left, right);
        }

        if(arr[0] >= target && arr[pivo] <= target){
            return binarySearch(arr, target, left, pivo);
        } else {
            return binarySearch(arr, target, pivo + 1, right);
        }
    }

    public static int binarySearch(int[] arr, int target, int left, int right){
        while(left <= right){
            int middle = (left + right) / 2;
            if(arr[middle] == target) return middle;

            if(arr[middle] > target){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int shiftSearch(int[] arr, int target){
        // 8 9 10 1 2 3 4 5 6 7 8
        int size = arr.length;

        if(size <= 1) {
            if(target == arr[0]) return 0;
            return -1;
        }

        boolean isShifted = arr[0] > arr[size -1];

        int left = 0, shift = 0;
        int right = size - 1;

        // O(Logn)
        if(isShifted) {
            while (left <= right) {
                int middle = (left + right) / 2;
                if (arr[middle] > arr[left]) {
                    left = middle + 1;
                } else if (arr[middle] < arr[left]) {
                    right = middle - 1;
                }

                if (left == middle) {
                    shift = left + 1;
                    break;
                }
            }
        }

        // O(Logn)
        while(right >= left || shift != 0){
            if(left >= arr.length)  left = shift = 0;

            int middle = ((left + right) / 2) + shift;
            if(arr[middle] == target) return middle;

            if(arr[middle] > target) {
                right = middle - 1;
                if(shift != 0) {
                    left = shift - 1;
                    shift = 0;
                }
            }
            else if(arr[middle] < target) left = middle + 1;
        }

//      O(n)
//        for(int i = 1; i < size; i++){
//            if(arr[i - 1] > arr[i]){
//                left = i;
//                right = i - 1;
//                shift = i + 1;
//                break;
//            }
//        }

        return -1;
    }

    public static int findShifted(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        boolean isShifted = true;
        if(arr[left] > arr[right]){

        }
        while(true){
            int middle = (left+right)/2;

             if(arr[middle] > arr[middle + 1]){
                 return middle;
             } else {
                 right = middle - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,9,10,1,2,3,4,5,6,7};
        int[] arrNotShifted = {1,2,3,4,5,6,7};
//        System.out.println("Find shifted => " + findShifted(arr));
        System.out.println(shiftSearchCorrect(arr, 10));

//        System.out.println(shiftSearch(arr, 10));
//        System.out.println(shiftSearch(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 3));
//        System.out.println(shiftSearch(arrNotShifted, 4));

    }
}
