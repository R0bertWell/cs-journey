package problem_solving.leetcode.medium;

public class Palindrome {
    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }


        return true;
    }

    public static boolean isPalindromeReversing(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i > -1; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("cddc"));
        System.out.println(isPalindrome("heleh"));
        System.out.println(isPalindrome("h"));
        System.out.println(isPalindrome("o"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("oho"));
        System.out.println(isPalindrome("ooii"));
        System.out.println(isPalindrome("//"));
        System.out.println("-----------------------");
        System.out.println(isPalindromeReversing("cddc"));
        System.out.println(isPalindromeReversing("heleh"));
        System.out.println(isPalindromeReversing("h"));
        System.out.println(isPalindromeReversing("o"));
        System.out.println(isPalindromeReversing("oho"));
        System.out.println(isPalindromeReversing("ooii"));
        System.out.println(isPalindromeReversing("//"));
        System.out.println(isPalindromeReversing(""));


    }
}
