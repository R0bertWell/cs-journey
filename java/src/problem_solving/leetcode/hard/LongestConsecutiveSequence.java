package problem_solving.leetcode.hard;

import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutiveBrute(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int longestConsecutive = 1;
        int candidate = 1;
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            if(prev == curr) continue;

            if(prev + 1 == curr){
                candidate++;
            } else {
                candidate = 1;
            }

            prev = curr;
            longestConsecutive = Math.max(longestConsecutive, candidate);
        }

        return longestConsecutive;
    }

    // 1 2 3 4 5 6

    // 10 1 2 3 4 5

    // 1 2 3 10 11 12 13 14 15
    public static int longestConsecutiveBetter(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                int nextNum = num + 1;
                while (set.contains(nextNum)) {
                    length++;
                    nextNum++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println("======================BRUTE===================");
        System.out.println(longestConsecutiveBrute(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutiveBrute(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutiveBrute(new int[]{1,0,1,2}));
        System.out.println("================= ENHANCED ===================");
        System.out.println(longestConsecutiveBetter(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutiveBetter(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutiveBetter(new int[]{1,0,1,2}));

    }
}
