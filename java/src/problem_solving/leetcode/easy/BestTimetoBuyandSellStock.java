package problem_solving.leetcode.easy;

public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;

        int maxProfit = 0;

        int lowest = prices[0];
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - lowest);
            lowest = Math.min(lowest, prices[i]);
        }

        return maxProfit;
    }

    public static int maxProfitIfs(int[] prices) {
        int maxProfit = 0;
        int lowest = Integer.MAX_VALUE;

        for(int price : prices){
            if(price < lowest) lowest = price;

            int profit = price - lowest;

            if(profit > maxProfit) maxProfit = profit;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
