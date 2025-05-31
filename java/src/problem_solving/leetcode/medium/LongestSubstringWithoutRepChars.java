package problem_solving.leetcode.medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepChars {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int start = 0, maxLength = 0;
        for(int end = 0 ; end < s.length(); end++){
            char c = s.charAt(end);

            if(charMap.containsKey(c) && charMap.get(c) >= start){
                start = charMap.get(c) + 1;
            }

            maxLength = Math.max(maxLength, (end - start + 1));
            charMap.put(c, end);
        }

        return maxLength;
    }

    private static void assertThat(int res, int ans){
        if(ans != res) throw new AssertionError("Answer : " + ans + " != Result : " + res);
    }

    public static void main(String[] args) {
        assertThat(lengthOfLongestSubstring("abcabcbb"), 3);
        assertThat(lengthOfLongestSubstring("bbbbb"), 1);
        assertThat(lengthOfLongestSubstring("pwwkew"), 3);
    }
}
