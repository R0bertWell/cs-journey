package problem_solving.leetcode.medium;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, HashMap<Character, Integer>> charCounterMap = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){
            HashMap<Character, Integer> strMap = new HashMap<>();
            String curr = strs[i];

            for(int j = 0; j < curr.length(); j++){
                char c = curr.charAt(j);
                if(strMap.containsKey(c)){
                    strMap.put(c, strMap.get(c) + 1);
                } else {
                    strMap.put(c, 1);
                }
            }

            boolean found = false;
            if(!charCounterMap.isEmpty()) {
                for (Map.Entry<Integer, HashMap<Character, Integer>> entry : charCounterMap.entrySet()) {
                    if(entry.getValue().equals(strMap)){
                        List<String> list = anagrams.get(entry.getKey());
                        list.add(curr);
                        found = true;
                        break;
                    }
                }
            }

            if(!found){
                anagrams.add(new ArrayList<>());
                int index = anagrams.size() - 1;
                charCounterMap.put(index, strMap);
                List<String> list = anagrams.get(index);
                list.add(curr);
            }
        }

        return anagrams;
    }

    public static List<List<String>> groupAnagramsEnhanced(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            int[] letters = new int[26];
            for (char str : s.toCharArray()) {
                int index = str - 'a';
                letters[index]++;
            }

            String key = Arrays.toString(letters);
            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                hashMap.put(key, list);
            }
//            hashMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strings = {
                "eat","tea","tan","ate","nat","bat"
        };
        System.out.println(groupAnagramsEnhanced(strings));
        strings = new String[]{
                "cab","tin","pew","duh","may","ill","buy","bar","max","doc"
        };
        System.out.println(groupAnagramsEnhanced(strings));
        strings = new String[]{""};
        System.out.println(groupAnagramsEnhanced(strings));
        strings = new String[]{"a"};
        System.out.println(groupAnagramsEnhanced(strings));
        strings = new String[]{
                "eat","tea","tan","ate","nat","bat"
        };
        System.out.println(groupAnagrams(strings));
        strings = new String[]{
                "cab","tin","pew","duh","may","ill","buy","bar","max","doc"
        };
        System.out.println(groupAnagrams(strings));
        strings = new String[]{""};
        System.out.println(groupAnagrams(strings));
        strings = new String[]{"a"};
        System.out.println(groupAnagrams(strings));

    }
}
