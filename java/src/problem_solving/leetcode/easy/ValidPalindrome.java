package problem_solving.leetcode.easy;

import java.util.Locale;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        StringBuilder str = new StringBuilder();
        int len = cleaned.length() - 1;
        for(int i = len; i >= 0; i--){
            char c = cleaned.charAt(i);
            str.append(c);
        }

        return str.toString().equals(cleaned);
    }

    // 48 - 57 -> 0-9
    public static boolean isPalindromeEnhancedPointers(String s) {
        String cleaned = s.toLowerCase().trim();
        // [^a-zA-Z0-9] Nega caracteres que não sejam a-z A-Z e 0-9
        if(cleaned.isEmpty() || cleaned.length() == 1) return true;

        boolean isPalin = true;
        int left = 0 , right = cleaned.length() - 1;
        while(left <= right) {
            char leftChar = cleaned.charAt(left);
            char rightChar = cleaned.charAt(right);
            if (leftChar == rightChar) {
                left++;
                right--;
            } else if (((leftChar >= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9')) &&
                    ((rightChar >= 'a' && rightChar <= 'z') || (rightChar >= '0' && rightChar <= '9'))) { // Can use isLetterOrDigit from Character
                return false;
            }

            if (leftChar >= 'a' && leftChar <= 'z' || leftChar >= '0' && leftChar <= '9') {
                while (left < right && ((rightChar < 'a' || rightChar > 'z') && (rightChar < '0' || rightChar > '9'))) {
                    right--;
                    rightChar = cleaned.charAt(right);
                }
            } else {
                while ((left < right) && ((leftChar < 'a' || leftChar > 'z') && (leftChar < '0' || leftChar > '9'))) {
                    left++;
                    leftChar = cleaned.charAt(left);
                }
            }
        }
        return isPalin;
    }

    public static boolean isPalindromeEnhancedPointersBetter(String s) {
        int L = 0, R = s.length() - 1;

        while (L < R) {
            while (L < R && !Character.isLetterOrDigit(s.charAt(L))) {
                L++;
            }
            while (L < R && !Character.isLetterOrDigit(s.charAt(R))) {
                R--;
            }
            if (L < R && Character.toLowerCase(s.charAt(L)) != Character.toLowerCase(s.charAt(R))) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeEnhancedPointersBetter("a"));
        System.out.println(isPalindromeEnhancedPointersBetter(" "));
        System.out.println(isPalindromeEnhancedPointersBetter("a c a"));

        System.out.println(isPalindromeEnhancedPointers("8V8K;G;K;V;"));
        System.out.println(isPalindromeEnhancedPointers("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeEnhancedPointers(".,"));
        System.out.println(isPalindromeEnhancedPointers("b0b"));
        System.out.println(isPalindromeEnhancedPointers("acb"));
        System.out.println(isPalindromeEnhancedPointers("a"));

        System.out.println(isPalindromeEnhancedPointers("0P"));
        System.out.println(isPalindromeEnhancedPointers("bbc"));
        System.out.println(isPalindromeEnhancedPointers("a b"));
        System.out.println(isPalindromeEnhancedPointers("race a car"));
        System.out.println(isPalindromeEnhancedPointers(" "));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));

    }
}
