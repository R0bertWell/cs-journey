package problem_solving.challenges;

public class SentenceCapitalization {
    public static String capitalize(String sentence){
        String[] splited = sentence.toLowerCase().split(" ");

        for(int i = 0; i < splited.length; i++){
            char c = (char) (splited[i].charAt(0) - 32);
            splited[i] = c + splited[i].substring(1);
        }

        StringBuilder sentenceBuilder = new StringBuilder();
        for(int i = 0; i < splited.length; i++){
            sentenceBuilder.append(splited[i]);
            if(i != splited.length - 1){
                sentenceBuilder.append(" ");
            }
        }
        return sentenceBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(capitalize("hello world"));
    }
}
