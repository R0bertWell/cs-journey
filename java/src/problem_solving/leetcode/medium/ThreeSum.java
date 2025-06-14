package problem_solving.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue; // Jump duplicates at fixed start
            if(nums[i] > 0) break;

            int left = i + 1 ;
            int right = nums.length - 1 ;


            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++; // Jump duplicates from left
                    while (left < right && nums[right] == nums[right - 1]) right--; // Jump duplicates from right

                    left++;
                    right--;
                } else if(sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-5, 1, 1, 2, 2, 3, 3, 4, 4}));

        System.out.println(threeSum(new int[]{-2,1,1,1,2}));

        System.out.println(threeSum(new int[]{-2,0,1,1,2}));

        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));

        System.out.println(threeSum(new int[]{0,1,1}));

        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
