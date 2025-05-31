package problem_solving.challenges;

public class FizzBuzz {

    public static void fizzBuzz(int n){
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            } else if(i % 3 == 0){
                System.out.println("Fizz");
            } else if(i % 5 == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void fizzBuzzBetter(int n){
        for(int i = 1; i <= n; i++){
            String sentence = "";
            // Or stringBuilder

            if(i % 3 == 0) sentence = sentence.concat("Fizz");
            if(i % 5 == 0) sentence = sentence.concat("Buzz");

            System.out.println(sentence.length() > 0 ? sentence : i);
        }
    }

    public static void main(String[] args) {
        fizzBuzz(15);
        System.out.println("---------------------");
        fizzBuzzBetter(15);

    }
}
