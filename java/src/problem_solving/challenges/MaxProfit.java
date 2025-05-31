package problem_solving.challenges;

public class MaxProfit {

    public static void maxProfitCorrect(int[] profits){
        int min = profits[0];
        int maxProfit = 0;
        for(int i = 1; i < profits.length; i++){
            int currentPrice = profits[i];
            min = Math.min(currentPrice, min);

            int potentialProfit = currentPrice - min;

            maxProfit = Math.max(maxProfit, potentialProfit);
        }

        System.out.printf("The best profit is %d", maxProfit);
        System.out.println();
    }

    public static void maxProfit(int[] profits){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int profit : profits){
            min = Math.min(profit, min);
            max = Math.max(profit, max);
        }

        System.out.printf("The best profit is %d", max - min);
        System.out.println();
    }

    public static void main(String[] args) {
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        maxProfitCorrect(new int[]{7, 1, 5, 3, 6, 4});
        maxProfitCorrect(new int[]{1, 10, 5, 3, 6, 4});
    }
}
