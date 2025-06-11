package problem_solving.leetcode.easy;

import java.util.HashMap;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        HashMap<Character, Integer> ransomMap = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++){
            char ransomChar = ransomNote.charAt(i);
            ransomMap.put(ransomChar, ransomMap.getOrDefault(ransomChar, 0) + 1);
        }

        for(int i = 0; i < magazine.length(); i++){
            if(ransomMap.isEmpty()) return true;
            char c = magazine.charAt(i);
            Integer value = ransomMap.get(c);

            if(value == null) continue;
            if (--value == 0) {
                ransomMap.remove(c);
            } else {
                ransomMap.put(c, value);
            }
        }

        return ransomMap.isEmpty();
    }

    public static boolean canConstructBetter(String ransomNote, String magazine) {
        int[] counts = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i) - 'a']++;
        }

        // Tenta montar a nota com as letras disponíveis
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (counts[index] == 0) {
                return false; // Letra necessária não está mais disponível
            }
            counts[index]--;
        }

        return true; // Todas as letras da nota foram encontradas
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstructBetter("a", "b"));
        System.out.println(canConstructBetter("aa", "ab"));
        System.out.println(canConstructBetter("aa", "aab"));
    }
}
