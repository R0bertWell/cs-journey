package problem_solving.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] daysToHigherTemperature(int[] temperatures){
        List<int[]> temperatureMap = new ArrayList<>();
        int[] answer = new int[temperatures.length]; // [0,0,0,0,0,0,0,0]
        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];
            int j = temperatureMap.size() - 1;
            while(j >= 0){
                if(temperatureMap.get(j)[0] < temp){
                    answer[temperatureMap.get(j)[1]] = i - temperatureMap.get(j)[1];
                    temperatureMap.remove(j);
                }
                j--;
            }

            temperatureMap.add(new int[]{temp, i});
        }

        return answer;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] prev = stack.pop();
                answer[prev[1]] = i - prev[1];
            }
            stack.push(new int[]{temp, i});
        }
        return answer;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        daysToHigherTemperature(new int[]{73,74,75,71,69,72,76,73});
    }
}
