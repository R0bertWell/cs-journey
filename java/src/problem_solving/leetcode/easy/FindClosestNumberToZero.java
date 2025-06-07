package problem_solving.leetcode.easy;

public class FindClosestNumberToZero {
    public static int findClosestNumberToZero(int[] nums) {
        int closestToZero = nums[0];
        for(int num : nums){
            if(num == 0) return 0;

            if(num < 0 && Math.abs(num) < Math.abs(closestToZero)){
                closestToZero = num;
            } else if(num > 0 && num <= Math.abs(closestToZero)){
                closestToZero = num;
            }
        }

        return closestToZero;
    }

    public static void main(String[] args) {
        System.out.println(findClosestNumberToZero(new int[]{2,5,5,5,-1,100000,2}));
        System.out.println(findClosestNumberToZero(new int[]{2,1,1,-1,100000}));
        System.out.println(findClosestNumberToZero(new int[]{-4,-2,-1,4,8, 1}));
        System.out.println(findClosestNumberToZero(new int[]{-1000, -1000, 999}));
        System.out.println(findClosestNumberToZero(new int[]{-10000, 1009}));
        System.out.println(findClosestNumberToZero(new int[]{-4,-2,1,4,8}));
        System.out.println(findClosestNumberToZero(new int[]{2,-1,1}));
    }
}
