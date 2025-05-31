package dsa.recursions;

import java.util.Arrays;

public class Fibonacci {
    /*
    Explanation :
        To find a fibonacci number, you must respect the follow formula : F(n) = F(n-1) + F(n-2).
        Respecting n >= 1;
        Since a fibonacci number is a sum between 2 number in sequence starting from 0 and 1.
        Attention: The start of fibonacci sequence depends on the used convetion :
            In math : F(0) = 0 , F(1) = 1
                F(n)=F(n−1)+F(n−2), para n ≥ 2
            In programming and computing: F(1) = 1 , F(2) = 1
                F(n)=F(n−1)+F(n−2), para n ≥ 3
    Sample :
        0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, ..
     */
    public static int fibLoop(int n) {

        // Nesse eu decidi retonar como n == 1 o proprio 0, pois é o primeiro F(0) = 0
        if(n <= 1) return 0;


        int curr = 0;
        int prev = 1;
        int temp;
        while(n >= 2){
            temp = curr;
            curr += prev;
            prev = temp;
            n--;
        }

        return curr;
    }

    public static int fibLoopBet(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;

        int prev = 0, curr = 1;
        int value = 1;

        for(int i = 2; i <= n; i++){
            value = prev + curr;
            prev = curr;
            curr = value;
        }

//        while(n >= 2){
//            value = prev + curr;
//            prev = curr;
//            curr = value;
//            n--;
//        }

        return value;
    }

    public static int fibRecursive(int n) {
        // F(n) = F(n - 1) + F(n - 2)
        // Sendo F(1) = 1, F(2) = 1 ( 0 + 1 )

        if(n <= 2) return 1;
        int res = fibRecursive(n - 1) + fibRecursive(n - 2);
        System.out.printf("Para 'n' = %s ", n);
        System.out.println();
        System.out.printf("F(%s) = F(%s) + F(%s) = %s", n, n - 1, n - 2, res);
        System.out.println();
        return res;
    }

//    public static int fibMemoization(int n){
//        if(n <= 0) return 0;
//        int[] memo = new int[n + 1];
//        return fibMemoizationHelper(n, memo);
//    }
//
//    public static int fibMemoizationHelper(int n, int[] memo){
//        if(n <= 2) return 1;
//        if(memo[n] != 0){
//            return memo[n];
//        }
//
//        memo[n] = fibMemoizationHelper(n - 1, memo) + fibMemoizationHelper(n - 2, memo);
//
//        return memo[n];
//    }
//

    public static int fibMemoization(int n) {
        if (n <= 0) return 0;
        int[] memo = new int[n + 1];
        return fibMemoizationHelper(n, memo, 0);
    }

    private static int fibMemoizationHelper(int n, int[] memo, int depth) {
        // Criando uma indentação para visualizar a profundidade da recursão
        String indent = "  ".repeat(depth);
        System.out.println(indent + "fib(" + n + ") chamado");

        // Exibir estado da memória antes da computação
        System.out.println(indent + "  Estado da memória: " + Arrays.toString(memo));

        // Base case
        if (n <= 2) {
            System.out.println(indent + "→ Retornando 1 (caso base)");
            return 1;
        }

        // Se já foi calculado, retornamos direto
        if (memo[n] != 0) {
            System.out.println(indent + "→ Retornando memo[" + n + "] = " + memo[n]);
            return memo[n];
        }

        // Recursão
        System.out.println(indent + "→ Calculando fib(" + (n - 1) + ") + fib(" + (n - 2) + ")");
        memo[n] = fibMemoizationHelper(n - 1, memo, depth + 1) + fibMemoizationHelper(n - 2, memo, depth + 1);

        // Exibir estado da memória após o cálculo
        System.out.println(indent + "  Estado atualizado da memória: " + Arrays.toString(memo));
        System.out.println(indent + "→ memo[" + n + "] = " + memo[n] + " (calculado)");

        return memo[n];
    }

    public static void main(String[] args) {
        int fib = 10;
        for(int i = 0; i <= fib; i++){
            System.out.printf("Fibonacci Loop de %s : [%s]", i, fibLoop(i));
            System.out.println();
        }

        for(int i = 0; i <= fib; i++){
            System.out.printf("Fibonacci Loop Better de %s : [%s]", i, fibLoopBet(i));
            System.out.println();
        }

        System.out.println("=============================================");
        System.out.println("FIBONACCI RECURSIVO");
        System.out.println("=============================================");
        for(int i = 0; i <= fib; i++){
            System.out.printf("Fibonacci Recursive de %s ", i);
            System.out.println();
            System.out.printf("Resultado => [%s]", fibRecursive(i));
            System.out.println();
        }

        System.out.println("=============================================");
        System.out.println("FIBONACCI RECURSIVO MEMOIZATION");
        System.out.println("=============================================");
        for(int i = 0; i <= fib; i++){
            System.out.printf("Fibonacci Recursive de %s ", i);
            System.out.println();
            System.out.printf("Resultado => [%s]", fibMemoization(i));
            System.out.println();
        }
    }

}
