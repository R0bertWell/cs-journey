package problem_solving.leetcode.easy;

import java.util.Arrays;
import java.util.Objects;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(t.length() > s.length() || t.length() < s.length()) return false;

        int[] letterS = new int[26];
        int[] letterT = new int[26];

        for(int i = 0; i < t.length(); i++){
            int indexS = s.charAt(i) - 'a';
            int indexT = t.charAt(i) - 'a';

            letterS[indexS] ++;
            letterT[indexT] ++;
        }

        return Arrays.equals(letterS, letterT);
//        for(int i = 0; i < 26; i++){
//            if(letterS[i] != letterT[i]) return false;
//        }

//        return true;
    }

    public static boolean isAnagramEnhanced(String s, String t) {
        if(t.length() > s.length() || t.length() < s.length()) return false;

        int[] letter = new int[26];

        for(int i = 0; i < t.length(); i++){
            int indexS = s.charAt(i) - 'a';
            int indexT = t.charAt(i) - 'a';

            letter[indexS]++;
            letter[indexT]--;
        }

        for(int i = 0; i < 26; i++){
            if(letter[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagramEnhanced("anagram", "nagaram"));
        System.out.println(isAnagramEnhanced("rat", "car"));
        System.out.println(isAnagramEnhanced("anagtam", "nbgbram"));

    }
}
