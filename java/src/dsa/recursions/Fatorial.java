package dsa.recursions;

public class Fatorial {

    public static int fac(int n){
        if(n <= 1){
            return 1;
        }

        int res = 1;
//        for(int i = 1; i <= n; i++){
//            res *= i;
//        }

        while(n >= 1){
            res *= n;
            n--;
        }

        return res;
    }

    public static int facRecursive(int n){
        if(n <= 1) return 1;
        return n * facRecursive(n - 1);
    }

    public static void main(String[] args) {
        int factorial = 15;
        for(int i = 0; i <= factorial; i++){
            System.out.printf("Fatorial de %s : [%s]", i, fac(i));
            System.out.println();
        }

        for(int i = 0; i <= factorial; i++){
            System.out.printf("Fatorial Recursivo de %s : [%s]", i, facRecursive(i));
            System.out.println();
        }
    }
}
