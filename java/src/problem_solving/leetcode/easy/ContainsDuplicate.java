package problem_solving.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<>();

        for(int num : nums){
            if(intSet.contains(num)){
                return true;
            }

            intSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        containsDuplicate(new int[]{1,2,3,1});
        containsDuplicate(new int[]{1,2,3,4});
        containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
    }
}
