package problem_solving.leetcode.medium;

import dsa.stacks.Stack;

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // Ordena os intervalos pelo valor de início
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // Se a lista está vazia ou o último intervalo não se sobrepõe ao atual
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Mescla os intervalos: atualiza o fim do último intervalo
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        // Converte a lista para array e retorna
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        merge(new int[][]{new int[]{1,4}, new int[]{0,1}});
        merge(new int[][]{new int[]{1,4}, new int[]{0,4}});
        merge(new int[][]{new int[]{1,4}, new int[]{0,0}});
        merge(new int[][]{new int[]{1,4}, new int[]{5,6}});
        merge(new int[][]{new int[]{1,4}, new int[]{4,5}});
        merge(new int[][]{new int[]{1,3}, new int[]{2,6}, new int[]{8,10}, new int[]{15,18}});
    }
}
