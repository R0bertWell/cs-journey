package problem_solving.leetcode.easy;

public class SecondHighest {
    public static int secondHighest(int[] nums){
        if(nums.length <= 1) throw new RuntimeException("Não existe segundo maior número, pois a lista tem apenas um elemento");

        int highest = Integer.MIN_VALUE;
        int second = highest;

        for(int num : nums){
            if(num > highest){
                second = highest;
                highest = num;
            } else if(num > second && num != highest){
                second = num;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        secondHighest(new int[]{Integer.MIN_VALUE + 1, 1});

        secondHighest(new int[]{1,2,3,4,5,6,7,8});
        secondHighest(new int[]{1,9,3,4,5,6,7,8});
        secondHighest(new int[]{10,1,2,3,4,5,10,6,7,8});
    }
}
