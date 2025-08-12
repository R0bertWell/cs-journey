package problem_solving.leetcode.medium;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxWater = 0;

        int left = 0, right = height.length - 1;
        while(left < right){
            int lowestCol;
            if(height[left] < height[right]){
                lowestCol = height[left];
                left++;
            } else {
                lowestCol = height[right];
                right--;
            }

            maxWater = Math.max(maxWater, lowestCol * (right - left + 1));
        }

        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}