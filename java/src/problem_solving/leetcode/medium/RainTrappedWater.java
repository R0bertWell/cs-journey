package problem_solving.leetcode.medium;

public class RainTrappedWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     */

    public static int trap(int[] height) {
        if(height.length <= 2) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // update the left highest height
                } else {
                    trappedWater += leftMax - height[left]; // calc trapped watter
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // update the right highest height
                } else {
                    trappedWater += rightMax - height[right]; // calc trapped watter
                }
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{1, 0, 0 , 0, 0 , 0, 0, 0, 0, 0, 10}));
        System.out.println(trap(new int[]{0, 0, 1}));
        System.out.println(trap(new int[]{2, 0, 1, 0, 1}));
        System.out.println(trap(new int[]{2, 0, 0, 2}));
        System.out.println(trap(new int[]{2, 2, 2, 2}));
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}