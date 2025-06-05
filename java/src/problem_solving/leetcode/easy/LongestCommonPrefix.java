package problem_solving.leetcode.easy;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String currentStr = strs[0];
        int index = 0;
        while(true){

            if(index >= currentStr.length()) return currentStr.substring(0, index);

            char currentChar = currentStr.charAt(index);

            for(int j = 1; j < strs.length; j++){
                if(index >= strs[j].length() || strs[j].charAt(index) != currentChar){
                    return currentStr.substring(0, index);
                }
            }
            index++;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a","ac"}));
        System.out.println(longestCommonPrefix(new String[]{"cir","car"}));
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"racecar","r","rog"}));


    }
}