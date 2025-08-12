package problem_solving.leetcode.easy;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int prevHighFreq = 0;
        int majority = 0;
        for(int num : nums){
            int currFreq;
            if(numMap.containsKey(num)){
                currFreq = numMap.get(num) + 1;
                numMap.put(num, currFreq);
            } else {
                currFreq = 1;
                numMap.put(num, 1);
            }

            if(currFreq > prevHighFreq){
                prevHighFreq = currFreq;
                majority = num;
            }
        }

        return majority;
    }

    public int majorityElementEnhancedBetter(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }

    public int majorityElementEnhanced2(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int prevHighFreq = 0;
        int majority = 0;
        for(int i = 0; i < nums.length; i++){
            int currFreq;
            int num = nums[i];
            if(numMap.containsKey(num)){
                currFreq = numMap.get(num) + 1;
                numMap.put(num, currFreq);
            } else {
                currFreq = 1;
                numMap.put(num, 1);
            }

            if(currFreq > prevHighFreq){
                prevHighFreq = currFreq;
                majority = num;
            }

            if(prevHighFreq > nums.length - i) break;
        }

        return majority;
    }

    public int majorityElementEnhanced(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int prevHighestFreq = 0;
        int majority = 0;
        for(int num : nums){
            numMap.put(num, 1 + numMap.getOrDefault(num, 0));
            int currFreq = numMap.get(num);
            if (currFreq > prevHighestFreq) {
                prevHighestFreq = currFreq;
                majority = num;
            }

        }

        return majority;
    }
}
