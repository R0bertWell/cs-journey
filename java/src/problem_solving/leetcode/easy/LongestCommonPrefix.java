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

    public static String longestCommonPrefixEnhanced(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Reduz o prefixo até encontrar correspondência
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
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