package problem_solving.leetcode.easy;

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int answer = 0;
        int prev = romanMap.get(s.charAt(0));
        for(char c : s.toCharArray()){
            int curr = romanMap.get(c);
            if(prev < curr){
                answer += (curr - (prev * 2));
            } else {
                answer += curr;
            }
            prev = curr;
        }

        return answer;
    }

    public static int romanToIntOtherWay(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int answer = romanMap.get(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            int curr = romanMap.get(s.charAt(i));
            int prev = romanMap.get(s.charAt(i - 1));
            if(curr > prev){
                answer += ((curr) - (prev * 2));
            } else {
                answer += curr;
            }
        }

        return answer;
    }

    public static int romanToIntOtherWay2(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int answer = 0;

        int index = 0, length = s.length();
        int prev = 0;
        while(index < length){
            int curr = romanMap.get(s.charAt(index));
            if(index < (length - 1) && curr < (prev = romanMap.get(s.charAt(index + 1)))){
                answer += prev - curr;
                index+=2;
            } else {
                answer += curr;
                index++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("============= FIRST ===============");
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println("============= SECOND ===============");
        System.out.println(romanToIntOtherWay("III"));
        System.out.println(romanToIntOtherWay("LVIII"));
        System.out.println(romanToIntOtherWay("MCMXCIV"));
        System.out.println("============= THIRD  ===============");
        System.out.println(romanToIntOtherWay2("III"));
        System.out.println(romanToIntOtherWay2("LVIII"));
        System.out.println(romanToIntOtherWay2("MCMXCIV"));

    }
}
