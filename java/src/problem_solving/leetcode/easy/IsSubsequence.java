package problem_solving.leetcode.easy;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int S = s.length();
        int T = t.length();
        if(S == 0) return true;
        if(T < S) return false;

        int i = 0;

        char curr = s.charAt(i);
        for(char c : t.toCharArray()){
            if(curr == c) {
               if (i == S - 1) return true;
               curr = s.charAt(++i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        String s1 = "axc", t1 = "ahbgdc";
        System.out.println(isSubsequence(s1, t1));
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }
}
