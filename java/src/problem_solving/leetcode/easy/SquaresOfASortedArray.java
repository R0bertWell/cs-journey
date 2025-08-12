package problem_solving.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquaresOfASortedArray {
    public static int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }


    public static int[] sortedSquaresEnhanedPointer(int[] nums) {
        int len = nums.length;
        int[] squares = new int[len];
        int left = 0, right = len - 1;
        int index = len - 1;

        while(left <= right){
            int value;
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                value = (int) Math.pow(nums[left++], 2);
            } else {
                value = (int)  Math.pow(nums[right--], 2);
            }
//            squares[index--] = (int) (Math.abs(nums[left]) > Math.abs(nums[right]) ?
//            Math.pow(nums[left++], 2) : Math.pow(nums[right--], 2));
            squares[index--] = value;
        }

        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquaresEnhanedPointer(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquaresEnhanedPointer(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));

    }
}
