package JUNE_MONTH_TRAINING.PREFIX_SUM_AND_GREEDY;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int currMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i:prices){
            currMin = Math.min(currMin,i);
            maxProfit = Math.max(maxProfit,i-currMin);
        }
        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
