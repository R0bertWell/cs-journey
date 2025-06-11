package problem_solving.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> characterSet = new HashSet<>();
        int jewelCount = 0;
        for(int i = 0; i < jewels.length(); i++){
            characterSet.add(jewels.charAt(i));
        }

        for(char c : stones.toCharArray()){
            if(characterSet.contains(c)){
                jewelCount++;
            }
        }

        return jewelCount;
    }

    public static void main(String[] args) {
        numJewelsInStones("aA", "aAAbbbb");
        numJewelsInStones("z", "ZZ");
    }
}