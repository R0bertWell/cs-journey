package problem_solving.leetcode.medium;

public class ProductOfArrayExceptSelf {

    // Brute force
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        for(int i = 0; i < length; i++){

            int j = 0;
            int multi = 1;
            while(j < length){
                if(i != j){
                    multi *= nums[j];
                }
                j++;
            }
            res[i] = multi;
        }

        return res;
    }

    public static int[] productExceptSelfOtherWay(int[] nums) {
        int length = nums.length;
        int l_mult = 1, r_mult = 1;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] res = new int[length];

        int j = length - 1;
        for(int i = 0; i < length; i++){
            left[i] = l_mult;
            right[j] = r_mult;
            l_mult *= nums[i];
            r_mult *= nums[j--];
        }

        for(int i = 0; i < length; i++){
            res[i] = left[i] * right[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelfOtherWay(new int[]{-1,1,0,-3,3}));
        System.out.println(productExceptSelfOtherWay(new int[]{1,2,3,4}));
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
    }
}
