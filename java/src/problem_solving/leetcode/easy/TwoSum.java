package problem_solving.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public static int[] twoSumBruteForce(int[] arr, int target){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static int[] twoSumPerfect(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rest = target - arr[i];
            if(map.containsKey(rest)){
                return new int[]{map.get(rest), i};
            } else {
                map.put(arr[i], i);
            }
        }

        return null;
    }

    public static int[] twoSumHorribleUsingList(int[] arr, int target){
        List<Integer> map = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int rest = target - arr[i];
            int ind = map.indexOf(rest);
            if(ind != -1){
                return new int[]{ind, i};
            } else {
                map.add(arr[i]);
            }
        }

        return null;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSumBruteForce(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 15)));
//        System.out.println(Arrays.toString(twoSumPerfect(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 17)));

        // Criar array gigante
        int size = 100_000;
        int[] bigArray = new int[size];
        for (int i = 0; i < size; i++) {
            bigArray[i] = i + 1;
        }

        int target = 0; // impossível de encontrar no array

        // Testar Brute Force
        long start = System.currentTimeMillis();
        int[] resultBrute = twoSumBruteForce(bigArray, target);
        long end = System.currentTimeMillis();
        System.out.println("BruteForce Result: " + Arrays.toString(resultBrute));
        System.out.println("BruteForce Time: " + (end - start) + " ms");

        // Testar Perfect (HashMap)
        start = System.currentTimeMillis();
        int[] resultPerfect = twoSumPerfect(bigArray, target);
        end = System.currentTimeMillis();
        System.out.println("Perfect Result: " + Arrays.toString(resultPerfect));
        System.out.println("Perfect Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        int[] resultList = twoSumHorribleUsingList(bigArray, target);
        end = System.currentTimeMillis();
        System.out.println("List Result: " + Arrays.toString(resultList));
        System.out.println("List Time: " + (end - start) + " ms");

    }

}
