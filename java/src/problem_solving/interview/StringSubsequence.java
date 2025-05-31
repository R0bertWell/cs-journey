package problem_solving.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringSubsequence {

    public static int subsequence(String s, String[] words){

        //HashMap<Character, ArrayList<Integer>> mainStringMap = getTheStringMap(s);
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        // letter -> (indices) 0,2,6

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }

//        return findSubsequencesCount(words, mainStringMap);
        int subsequences = 0;

        for(String w : words){
            if(isSubsequence(s, w, map)){
                subsequences++;
            }
        }

        return subsequences;
    }

    public static boolean isSubsequence(String mainWord, String word, HashMap<Character, ArrayList<Integer>> indexMap){
        if(word.length() > mainWord.length()){
            return false;
        }

        HashMap<Character, ArrayList<Integer>> indexesPassed = new HashMap<>();

        boolean isSub = true;
        int letterLastIndex = 0;

        for(char c : word.toCharArray()){
            if(indexMap.containsKey(c)){
                if(indexesPassed.containsKey(c)){
                    ArrayList<Integer> arrayList = indexesPassed.get(c);
                    ArrayList<Integer> mapList = indexMap.get(c);

                    int lastIndex = arrayList.get(arrayList.size() - 1);
                    if(lastIndex >= mapList.get(mapList.size() - 1)){
                        isSub = false;
                        break;
                    } else {
                        arrayList.add(mapList.get(arrayList.size()));
                        indexesPassed.put(c, arrayList);
                        letterLastIndex = arrayList.get(arrayList.size() - 1);
                    }
                } else {
                    ArrayList<Integer> listTest = indexMap.get(c);
                    int currentLastIndex = indexMap.get(c).get(0);

                    if(currentLastIndex < letterLastIndex){
                        if(listTest.size() > 1){
                            for(Integer integer : listTest){
                                if(integer > currentLastIndex){
                                    currentLastIndex = integer;
                                    break;
                                }
                            }
                        }

                        if(currentLastIndex < letterLastIndex) {
                            isSub = false;
                            break;
                        }
                    }

                    letterLastIndex = currentLastIndex;

                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(letterLastIndex);
                    indexesPassed.put(c, arrayList);
                }
            } else {
                isSub = false;
                break;
            }
        }

        return isSub;
    }

    public static boolean isSubsequenceBetter(String mainWord, String word, HashMap<Character, ArrayList<Integer>> indexMap){
        if(word.length() > mainWord.length()){
            return false;
        }


        boolean isSub = true;
        int letterLastIndex = 0;
        HashMap<Character, ArrayList<Integer>> indexesPassed = new HashMap<>();

        for(char c : word.toCharArray()){
            if(indexMap.containsKey(c)){
                ArrayList<Integer> mapList = indexMap.get(c);
                if(indexesPassed.containsKey(c)){
                    ArrayList<Integer> arrayList = indexesPassed.get(c);

                    int lastIndex = arrayList.get(arrayList.size() - 1);
                    if(lastIndex >= mapList.get(mapList.size() - 1)){
                        isSub = false;
                        break;
                    } else {
                        arrayList.add(mapList.get(arrayList.size()));
                        indexesPassed.put(c, arrayList);
                        letterLastIndex = arrayList.get(arrayList.size() - 1);
                    }
                } else {
                    int currentLastIndex = mapList.get(0);

                    if(currentLastIndex < letterLastIndex){
                        for(Integer integer : mapList){
                            if(integer > currentLastIndex){
                                currentLastIndex = integer;
                                break;
                            }
                        }

                        if(currentLastIndex < letterLastIndex) {
                            isSub = false;
                            break;
                        }
                    }

                    letterLastIndex = currentLastIndex;

                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(letterLastIndex);
                    indexesPassed.put(c, arrayList);
                }
            } else {
                isSub = false;
                break;
            }
        }

        return isSub;
    }

    public static int subsequenceStack(String s, String[] words){
        HashMap<Character, Stack<Integer>> map = new HashMap<>();

        // letter -> (indices) 0,2,6

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            } else {
                Stack<Integer> stack = new Stack<>();
                stack.add(i);
                map.put(c, stack);
            }
        }

        int subsequences = 0;

        for(String w : words){
            if(w.length() > s.length()){
                continue;
            }

            HashMap<Character, Stack<Integer>> mapCoppy = new HashMap<>();
            for (Map.Entry<Character, Stack<Integer>> entry : map.entrySet()) {
                mapCoppy.put(entry.getKey(), (Stack<Integer>) entry.getValue().clone());
            }

            boolean isSub = false;

            for(char c : w.toCharArray()){
                if(mapCoppy.containsKey(c)){
                    Stack<Integer> indexes = mapCoppy.get(c);

                    if(indexes.size() == 0) {
                        isSub = false;
                        break;
                    }

                    indexes.pop();
                    isSub = true;
                } else {
                    isSub = false;
                    break;
                }
            }



            if(isSub){
                subsequences++;
            }
        }

        return subsequences;
    }

    public static void main(String[] args) {
        System.out.println(subsequence("abcde", new String[]{"a",  "bb", "acd", "ace"}));
        System.out.println(subsequence("aba", new String[]{"bab"}));
        System.out.println(subsequence("aab", new String[]{"ba"}));
        System.out.println(subsequence("dsahjpjauf", new String[]{"ahjpjau",  "ja", "ahbwzgqnuk", "tnmlanowax"}));
        System.out.println(subsequence("", new String[]{"ahjpjau",  "", "ahbwzgqnuk", "tnmlanowax"}));
        System.out.println(subsequence("", new String[]{"ahjpjau",  "ggdf", "ahbwzgqnuk", "tnmlanowax"}));
        System.out.println(subsequence("aaa", new String[]{"ahjpjau",  "", "ahbwzgqnuk", "tnmlanowax"}));

//        System.out.println(subsequenceStack("abcde", new String[]{"eca",  "bb", "acd", "ace"}));
//        System.out.println(subsequenceStack("abcde", new String[]{"a",  "bb", "acd", "ace"}));
//        System.out.println(subsequenceStack("dsahjpjauf", new String[]{"ahjpjau",  "ja", "ahbwzgqnuk", "tnmlanowax"}));
//        System.out.println(subsequenceStack("", new String[]{"ahjpjau",  "", "ahbwzgqnuk", "tnmlanowax"}));
//        System.out.println(subsequenceStack("aaa", new String[]{"ahjpjau",  "", "ahbwzgqnuk", "tnmlanowax"}));

    }
}
