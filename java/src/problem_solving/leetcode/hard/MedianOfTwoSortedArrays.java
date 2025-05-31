package problem_solving.leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MedianOfTwoSortedArrays {
    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     */

    // Log(m+n) way
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int newArrLength = nums1.length + nums2.length;
        int[] newArr = new int[newArrLength];

        int i = 0, j = 0, z = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                newArr[z++] = nums1[i++];
            } else {
                newArr[z++] = nums2[j++];
            }
        }

        while(i < nums1.length ){
            newArr[z++] = nums1[i++];
        }

        while(j < nums2.length ){
            newArr[z++] = nums2[j++];
        }

        return newArrLength % 2 != 0 ? newArr[newArrLength / 2] : (newArr[newArrLength / 2] + newArr[(newArrLength / 2) - 1] ) / 2d;
    }

    public static double findMedianOfTwoSortedArraysEnhanced(int[] nums1, int[] nums2){
        int totalLength = nums1.length + nums2.length;
        int mid = totalLength / 2;

        int i = 0, j = 0, counter = 0;
        int prev = 0, curr = 0;

        while(counter <= mid){
            prev = curr;
            if(i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])){
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
            counter++;
        }

        return totalLength % 2 == 0 ? (prev + curr) / 2d : curr;
    }

    public static void main(String[] args) {
        System.out.println("===== MEDIAN OF TWO SORTED ARRAYS =====");
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{1,3,7,9,10}, new int[]{3,4,4,4}));
        System.out.println("===== MEDIAN OF TWO SORTED ARRAYS ENHANCED =====");
        System.out.println(findMedianOfTwoSortedArraysEnhanced(new int[]{3}, new int[]{}));
        System.out.println(findMedianOfTwoSortedArraysEnhanced(new int[]{3}, new int[]{1}));
        System.out.println(findMedianOfTwoSortedArraysEnhanced(new int[]{3,4}, new int[]{1,2}));
        System.out.println(findMedianOfTwoSortedArraysEnhanced(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianOfTwoSortedArraysEnhanced(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianOfTwoSortedArraysEnhanced(new int[]{1,3,7,9,10}, new int[]{3,4,4,4}));
    }
}
