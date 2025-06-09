package problem_solving.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return List.of();

        List<String> ranges = new ArrayList<>();
        int prev = nums[0];
        int range = prev;
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            if(curr != prev + 1){
                String ranStr = String.valueOf(range);
                if(range != prev) ranStr += "->" + prev;
                ranges.add(ranStr);
                range = curr;
            }
            prev = curr;
        }

        String ranStr = String.valueOf(range);
        if(range != prev) ranStr += "->" + prev;
        ranges.add(ranStr);

        return ranges;
    }

    public static List<String> summaryRangesOtherWay(int[] nums) {
        if(nums.length == 0) return List.of();

        List<String> ranges = new ArrayList<>();
        int i = 0, n = nums.length;
        while(i < n){
            int start = nums[i];
            while(i < n - 1 && nums[i] + 1 == nums[i + 1]){
                i++;
            }

            if(start != nums[i]){
                ranges.add(start+"->"+nums[i]);
            } else {
                ranges.add(String.valueOf(start));
            }

            i++;
        }

        return ranges;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(summaryRangesOtherWay(new int[]{0,1,2,4,5,7}));
        System.out.println(summaryRangesOtherWay(new int[]{0,2,3,4,6,8,9}));

    }
}
