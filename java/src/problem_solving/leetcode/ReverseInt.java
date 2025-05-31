package problem_solving.leetcode;

import java.math.BigInteger;
import java.util.*;

public class ReverseInt {
    public static Integer reverseInteger(int num){
        String numS = String.valueOf(num); // Integer.toString()
        StringBuilder sb = new StringBuilder();
        for(int i = numS.length() - 1; i > -1; i--){
            sb.append(numS.charAt(i));
        }

        return Integer.valueOf(sb.toString());
    }

    public static Integer reverseIntegerBetter(int num){
        if(num == 0 || num < -2147483647 || num > 2147483646) return 0;

        StringBuilder sb = new StringBuilder();
        int signal = 1;
        if(num < 0){
            signal = -1;
            num *= signal;
        }

        while(num > 0){
            int cont = (num / 10),
                res = (num % 10);
            sb.append(res);
            num = cont;
        }


        try {
            long reversed = Long.parseLong(sb.toString()) * signal;
            if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
                return 0;
            }

            return (int) reversed;
        } catch (NumberFormatException e) {
            return 0; // Se mesmo o long estourar, retorna 0
        }
    }

    public static int myAtoi(String s) {
        s = s.trim();

        int length = s.length();

        if(length == 0) return 0;

        int i = 0;
        StringBuilder str = new StringBuilder();

        while(i < length){
            char c = s.charAt(i);

            if((c < 47 || c > 57) && (c != '-' && c != '+')){
                break;
            }

            if(i != 0 && (c == '-' || c == '+')){
                break;
            }

            i++;
            str.append(c);
        }

        if(str.length() == 0) return 0;

        BigInteger bigInteger = new BigInteger(str.toString());

        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
            bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        }
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0 ||
                bigInteger.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0){
            return Integer.MIN_VALUE;
        }

        return bigInteger.intValueExact(); // ou bigInteger.intValueExact() se quiser garantir precisão
    }

    public static boolean isPalindrome(int x) {
        // Números negativos nunca são palíndromos
        // Também eliminamos números que terminam em 0 (exceto o próprio 0)
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;

        // Reverte apenas metade do número
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // Para números com quantidade ímpar de dígitos, ignoramos o dígito do meio
        return x == reversed || x == reversed / 10;
    }

//    public static boolean isMatch(String s, String p) {
//        boolean match = true;
//        char previous = 0;
//
//        int arrayLength = Math.max(p.length(), s.length());
//        char[] array = new char[arrayLength];
//        int patternLength = 0;
//
//        for(int i = 0; i < p.length(); i++){
//            char pattern = p.charAt(i);
//            switch(pattern){
//                case '*':
//                    int z = i;
//                    int j = array.length - (array.length - i - 1);
//                    while(z < j){
////                        if(previous != 0){
////                            array[z] = previous ;
////                        } else {
//                        if(previous != pattern){
//                            array[z - 1] = pattern;
//                        }
//                        array[z] = previous;
////                        array[z] = pattern;
////                        }
//
//                        patternLength++;
//                        z++;
//                    }
//                    break;
//                default:
//                    array[i] = pattern;
//                    patternLength++;
//                    break;
//            }
//
//            previous = pattern;
//        }
//
//        if(patternLength < s.length()) return false;
//
//        int j = 0;
//        char currentPattern = array[j];
//        previous = 0;
//
//        for(int i = 0; i < s.length(); i++){
//            char c  = s.charAt(i);
//            int started = j;
//            switch (currentPattern) {
//                case '.' -> {
//                    if (previous != '*') {
//                        j++;
//                    }
//                }
//                case '*' -> {
//                    j++;
//                    i--;
//                    previous = currentPattern;
//                }
//
////                    if(j < array.length) currentPattern = array[j];
//                default -> {
//                    if (previous == '*') {
//                        if(currentPattern != c) {
//                            i--;
//                            j++;
//                        } else {
//                            continue;
//                        }
//                    } else
//                    if(previous == '.'){
//                        j++;
//                        continue;
//                    } else {
//                        if (currentPattern != c) return false;
//                        j++;
//                    }
//                }
//            }
//
//            if(j < array.length) currentPattern = array[j];
//        }
//
//        if(j < array.length - 1) return false;
//
//        return match;
//    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // string vazia com padrão vazio

        // Inicializa padrão com '*'
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // '*' elimina o caractere anterior
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' pode ignorar o caractere anterior
                    dp[i][j] = dp[i][j - 2]; // zero ocorrências

                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // uma ou mais ocorrências
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxAmount = 0;

        while(i < j){
            maxAmount = Math.max(maxAmount, (Math.min(height[i], height[j]) * (j - i)));
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }

        return maxAmount;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int z = j + 1; z < nums.length; z++) {
                    if(nums[i] + nums[j] + nums[z] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[z]);
                        Collections.sort(triplet); // Para evitar duplicatas com ordem diferente
                        set.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
    public static List<List<Integer>> threeSumGreat(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Ordena para usar a técnica de dois ponteiros

        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0){
                System.out.printf("nums[i] / nums[i - 1] -> %s / %s ", nums[i], nums[i - 1]);
                System.out.println("Next => "+ nums[i + 1]);
                System.out.println();
            }
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Evita duplicatas para i

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move ponteiros e evita duplicatas
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Precisa de um número maior
                } else {
                    right--; // Precisa de um número menor
                }
            }
        }

        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        String longestPrefix = "";
        char currentPrefix = strs[0].charAt(0);
        int minLength = Integer.MAX_VALUE;

        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        if(minLength == 0) return longestPrefix;
        if(strs.length == 1) return strs[0];

        int j = 0;
        for(int i = 1; i < strs.length; i++){
            if(j > minLength - 1) break;

            if(currentPrefix != strs[i].charAt(j)){
                break;
            }

            if(i >= strs.length - 1){
                longestPrefix = longestPrefix.concat(String.valueOf(currentPrefix));
                i = 0;
                j++;
                if(j > minLength - 1) break;
                currentPrefix = strs[i].charAt(j);
            }


        }

        return longestPrefix;
    }

    public static String longestCommonPrefixJump(String[] strs) {
        if(strs.length == 1) return strs[0];

        String shortestStr = strs[0];
        for (String str : strs) {
            if (str.length() < shortestStr.length()) {
                shortestStr = str;
            }
        }

        if(shortestStr.isEmpty()) return "";

        StringBuilder longestPrefix = new StringBuilder();

        for(int i = 0; i < shortestStr.length(); i++){
            char currentPrefix = shortestStr.charAt(i);
            for(String currentComp : strs){
                if(currentPrefix != currentComp.charAt(i)){
                    return longestPrefix.toString();
                }
            }

            longestPrefix.append(currentPrefix);
        }

        return longestPrefix.toString();
    }

    public static String longestCommonPrefixBetter(String[] strs) {
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


    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = head;
            int nodeSize = 0;

            while(dummy != null){
                dummy = dummy.next;
                nodeSize++;
            }

            // 5 - 2 = 3
            // 1 2 3 4 5

            int percurToRemove = nodeSize - n - 1;
            dummy = head;

            while(percurToRemove > 0){
                dummy = dummy.next;
                percurToRemove--;
            }

            dummy.next = dummy.next.next;

            return head;
        }
    }

    public boolean isValid(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' -> str.append(')');
                case '{' -> str.append('}');
                case '[' -> str.append(']');
                default -> {
                    if (str.isEmpty() || str.charAt(str.length() - 1) != c) {
                        return false;
                    }

                    str = new StringBuilder(str.substring(0, s.length() - 1));
                }
            }
        }

        return str.isEmpty();
    }

    public static List<Integer> getNumPairs(int serverNodes, List<Integer> serverFrom, List<Integer> serverTo,
                                            List<Integer> serverWeight, int signal_speed) {

        // Construir o grafo (não-direcionado)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= serverNodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < serverFrom.size(); i++) {
            int from = serverFrom.get(i);
            int to = serverTo.get(i);
            int weight = serverWeight.get(i);
            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }

        List<Integer> result = new ArrayList<>(Collections.nCopies(serverNodes, 0));

        for (int start = 1; start <= serverNodes; start++) {
            Set<Integer> visitedNodes = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[serverNodes + 1];

            queue.offer(new int[]{start, 0});
            visited[start] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int node = current[0];
                int sum = current[1];

                for (int[] neighbor : graph.get(node)) {
                    int next = neighbor[0];
                    int newSum = sum + neighbor[1];

                    if (!visited[next]) {
                        queue.offer(new int[]{next, newSum});
                        visited[next] = true;

                        if (newSum % signal_speed == 0) {
                            visitedNodes.add(next);
                        }
                    }
                }
            }

            result.set(start - 1, visitedNodes.size());
        }

        return result;
    }

    public static void main(String[] args) {
        getNumPairs(4, List.of(1,1,2), List.of(2,3,4), List.of(2,5,3), 5);
//        [1,2,3,4,5]
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        listNode.next = listNode1;

        System.out.println(Solution.removeNthFromEnd(listNode3, 2));

        System.out.println(Solution.removeNthFromEnd(listNode, 2));

        System.out.println(Solution.removeNthFromEnd(listNode4, 1));

        System.out.println(longestCommonPrefixBetter(new String[]{"flower","f", "f", ""}));

        System.out.println(longestCommonPrefixBetter(new String[]{"flower","flower","flowe","flow", "flo", "fl", "f", "f", "f", "f", "fl", "flower", "fl"}));

        System.out.println(longestCommonPrefixBetter(new String[]{"flower","flower","flower","flower"}));
        System.out.println(longestCommonPrefixBetter(new String[]{"flower","flow","flight"}));

        System.out.println(longestCommonPrefixJump(new String[]{"cir","car"}));
        System.out.println(longestCommonPrefixJump(new String[]{"ab","a"}));

        System.out.println(longestCommonPrefixJump(new String[]{"a","fukc","asdasdas"}));

        System.out.println(longestCommonPrefixJump(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefixJump(new String[]{"flower","flower","flower","flower"}));

        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(threeSumGreat(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(isMatch("aaa", "aaaa"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("mississippi", "mis*is*ip*."));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aa", "a"));

        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aa", ".a"));

        isPalindrome(2122);
        System.out.println((int) '9');
        System.out.println((int) '8');
        System.out.println((int) '7');
        System.out.println((int) '6');
        System.out.println((int) '5');
        System.out.println((int) '4');
        System.out.println((int) '3');
        System.out.println((int) '2');
        System.out.println((int) '1');
        System.out.println((int) '0');
        myAtoi("-91283472332");
        myAtoi("words and 987");
        myAtoi("1337c0d3");
        myAtoi("42");
        myAtoi("-42");
        myAtoi("    +42");
        String teste = " a      a ";
        teste = teste.trim();
        System.out.println(reverseIntegerBetter(1534236469));
        System.out.println(reverseInteger(1234));
        System.out.println(reverseInteger(5678));
        System.out.println(reverseIntegerBetter(-100000));
        reverseIntegerBetter(100000);

    }
}
