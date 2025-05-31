package problem_solving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AnyExercise {

    public static int longestSubsWithoutRepChars(String sentence){
        if (sentence.isEmpty()) return 0;

        HashMap<Character, Integer> vogalMap = new HashMap<>();
        int startIndex = 0;
        int longestSubs = 0;

        for(int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);
            if(vogalMap.containsKey(c) && vogalMap.get(c) >= startIndex){
                startIndex = vogalMap.get(c) + 1;
            }

            longestSubs = Math.max(longestSubs, i - startIndex + 1);
            vogalMap.put(c, i);
        }

        return longestSubs;
    }

    public static double medianOfTwoSortedArrays(int[] arr1, int[] arr2){
        double median;
        int finalLength = arr1.length + arr2.length;
        int[] finalArr = new int[finalLength];

        int firstArr = 0, secondArr = 0, finalIndex = 0;

        while(firstArr < arr1.length && secondArr < arr2.length){
            if(arr1[firstArr] > arr2[secondArr]){
                finalArr[finalIndex++] = arr2[secondArr++];
            } else {
                finalArr[finalIndex++] = arr1[firstArr++];
            }
        }

        while(firstArr < arr1.length){
            finalArr[finalIndex++] = arr1[firstArr++];
        }

        while(secondArr < arr2.length){
            finalArr[finalIndex++] = arr2[secondArr++];
        }

        median = (finalLength % 2) != 0 ?
                finalArr[(finalLength / 2)]
                :
                (double) (finalArr[finalLength / 2] + finalArr[(finalLength / 2) - 1]) / 2;

        return median;
    }

    public static double medianOfTwoSortedArraysEnhanced(int[] arr1, int[] arr2){
        int totalLength = arr1.length + arr2.length;
        int mid = totalLength / 2;

        int i = 0, j = 0, count = 0;
        int prev = 0, curr = 0;

        while(count <= mid){
            prev = curr;

            if (i < arr1.length && (j >= arr2.length || arr1[i] <= arr2[j])) {
                curr = arr1[i++];
            } else {
                curr = arr2[j++];
            }

            count++;
        }

        return totalLength % 2 == 0 ? (prev + curr) / 2d : curr;
    }

    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> first, LinkedList<Integer> second){
        LinkedList<Integer> resultList = new LinkedList<>();

        int resto = 0;
        while(!first.isEmpty() || !second.isEmpty() || resto != 0){
            int sum = resto;

            if(!first.isEmpty())  sum += first.pop();

            if(!second.isEmpty()) sum += second.pop();

            resto = sum / 10;
            resultList.add(sum % 10);
        }

        return resultList;
    }

    public static void main(String[] args) {
        System.out.println("===== LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS =====");
        System.out.println(longestSubsWithoutRepChars("abcabcbb"));
        System.out.println(longestSubsWithoutRepChars("bbbbb"));
        System.out.println(longestSubsWithoutRepChars("pwwkew"));
        System.out.println(longestSubsWithoutRepChars(" "));
        System.out.println(longestSubsWithoutRepChars("     "));
        System.out.println("===========================================================");
        System.out.println();
        System.out.println("===== MEDIAN OF TWO SORTED ARRAYS =====");
        System.out.println(medianOfTwoSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(medianOfTwoSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(medianOfTwoSortedArrays(new int[]{1,3,7,9,10}, new int[]{3,4,4,4}));
        System.out.println("===== MEDIAN OF TWO SORTED ARRAYS ENHANCED =====");
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{3}, new int[]{}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{3}, new int[]{1}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{3,4}, new int[]{1,2}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{1,3}, new int[]{2}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{1,2}, new int[]{3,4}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{1,3,7,9,10}, new int[]{3,4,4,4}));
        System.out.println("===== ADD TWO NUMBERS =====");
        LinkedList<Integer> linkedList1 = new LinkedList<>(Arrays.asList(2, 4, 3));
        LinkedList<Integer> linkedList2 = new LinkedList<>(Arrays.asList(5, 6, 4));

        System.out.println(addTwoNumbers(linkedList1, linkedList2));
        //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //Output: [8,9,9,9,0,0,0,1]

        linkedList1 = new LinkedList<>(Arrays.asList(9,9,9,9,9,9,9));
        linkedList2 = new LinkedList<>(Arrays.asList(9,9,9,9));
        System.out.println(addTwoNumbers(linkedList1, linkedList2));

        linkedList1 = new LinkedList<>(List.of(0));
        linkedList2 = new LinkedList<>(List.of(0));
        System.out.println(addTwoNumbers(linkedList1, linkedList2));

    }
}
