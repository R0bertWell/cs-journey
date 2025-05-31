package problem_solving.challenges;

import java.util.HashMap;

public class WordCounter {

    public static HashMap<String, Integer> countWords(String sentence){
        HashMap<String, Integer> wordCounterMap = new HashMap<>();
        String[] splitedSentence = sentence.toLowerCase().split("\\s+");

        for(String word : splitedSentence){
            if(wordCounterMap.containsKey(word)){
                wordCounterMap.put(word, wordCounterMap.get(word) + 1);
            } else {
                wordCounterMap.put(word, 1);
            }
        }

        return wordCounterMap;
    }

    public static void main(String[] args) {
        System.out.println(countWords("Eu                              sou junior do gera e o negocio é doidera Em fi Eu sou foda"));
    }
}
