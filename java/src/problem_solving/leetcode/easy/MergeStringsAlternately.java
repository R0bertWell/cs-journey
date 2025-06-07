package problem_solving.leetcode.easy;

public class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();

        int w1 = 0, w2 = 0;
        int invert = 1;
        while(w1 < word1.length() || w2 < word2.length()){
            if(invert == 1){
                if(w1 < word1.length()) {
                    str.append(word1.charAt(w1++));
                }
            } else {
                if(w2 < word2.length()) {
                    str.append(word2.charAt(w2++));
                }
            }
            invert *= -1;

        }

        return str.toString();
    }

    public static String mergeAlternatelyAnotherWay(String word1, String word2) {
        StringBuilder str = new StringBuilder();

        int first = 0, second = 0;
        while(first < word1.length() && second < word2.length()){
            str.append(word1.charAt(first++))
               .append(word2.charAt(second++));
        }

        while(first < word1.length()){
            str.append(word1.charAt(first++));
        }

        while(second < word2.length()){
            str.append(word2.charAt(second++));
        }

        return str.toString();
    }

    public static String mergeAlternatelyAnotherWay2(String word1, String word2) {
        StringBuilder str = new StringBuilder();

        int first = 0, second = 0;
        while(first < word1.length() || second < word2.length()) {
            if (first < word1.length()) str.append(word1.charAt(first++));
            if (second < word2.length()) str.append(word2.charAt(second++));
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println("======= FIRST ==========");
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
        System.out.println("======= SECOND ==========");

        System.out.println(mergeAlternatelyAnotherWay("abc", "pqr"));
        System.out.println(mergeAlternatelyAnotherWay("ab", "pqrs"));
        System.out.println(mergeAlternatelyAnotherWay("abcd", "pq"));
        System.out.println("======= THIRD ==========");
        System.out.println(mergeAlternatelyAnotherWay2("abc", "pqr"));
        System.out.println(mergeAlternatelyAnotherWay2("ab", "pqrs"));
        System.out.println(mergeAlternatelyAnotherWay2("abcd", "pq"));
    }
}
