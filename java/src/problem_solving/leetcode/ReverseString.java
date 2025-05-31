package problem_solving.leetcode;

public class ReverseString {
    public static String reverseString(String s){
//        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
//        String res = "";
        for(int i = s.length() - 1; i > -1; i--){
            char c = s.charAt(i);
            sb.append(c);
        }

//        for(int i = arr.length - 1; i > -1; i--){
//            sb.append(arr[i]);
//        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("reverseMe"));
        System.out.println(reverseString("Apple"));
        System.out.println(reverseString("Hello"));

    }
}
