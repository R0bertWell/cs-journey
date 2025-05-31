package problem_solving.leetcode.medium;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s.length() == 1) return s;

        String longestPalin = "";

        for (int i = 0; i < s.length(); i++) {

            String odd = expandAroundCenter(s, i, i); // even
            String even = expandAroundCenter(s, i, i + 1); // odd

            String longer = odd.length() > even.length() ? odd : even;

            if (longer.length() > longestPalin.length()) {
                longestPalin = longer;
            }

            i++;
        }

        return longestPalin;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("b"));
        System.out.println(longestPalindrome("bbbabab"));
    }
}
