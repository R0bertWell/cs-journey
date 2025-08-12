package problem_solving.leetcode.easy;

public class ReverseString {
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while(left <= right){
            char temp = s[right];
            s[right--] = s[left];
            s[left++] = temp;
        }
    }

    public static void reverseStringFor(char[] s) {
        int right = s.length - 1;
        for(int left = 0; left < s.length / 2; left++){
            char temp = s[left];
            s[left] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        reverseStringFor(new char[]{'H','a','n','n','a','h'});
        reverseString(new char[]{'h','e','l','l','o'});
        reverseStringFor(new char[]{'h','e','l','l','o'});

    }
}
