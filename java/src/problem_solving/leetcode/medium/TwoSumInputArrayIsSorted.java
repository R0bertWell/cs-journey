package problem_solving.leetcode.medium;

import java.util.HashMap;

public class TwoSumInputArrayIsSorted {
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> intMap = new HashMap<>();
        int left = 0, right = numbers.length - 1;
        while(left <= right){
            int restoLeft = target - numbers[left];
            int restoRight = target - numbers[right];

            if(restoLeft + restoRight == target) return new int[]{++left, ++right};

            if(intMap.containsKey(restoLeft)){
                return new int[]{intMap.get(restoLeft) + 1, left + 1};
            }
            if(intMap.containsKey(restoRight)){
                return new int[]{intMap.get(restoRight) + 1, right + 1};
            }


            intMap.put(numbers[right], right + 1);
            intMap.put(numbers[left], left + 1);
            right--;
            left++;
        }

        return new int[]{};
    }

    public static int[] twoSumSimple(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left <= right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{++left, ++right};
            } else if(sum < 0){
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        twoSum(new int[]{2,3,4}, 6);
        twoSum(new int[]{0,0,3,4}, 0);
        twoSum(new int[]{2,7,11,15}, 9);
        twoSum(new int[]{2,3,4}, 6);
        twoSum(new int[]{-1,0}, -1);
    }
}
