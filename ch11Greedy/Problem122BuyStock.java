package ch11Greedy;

public class Problem122BuyStock {
    /*
    *
    * */
    public int maxProfit(int[] prices) {
        int[] diff = new int[prices.length - 1];
        int profit = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }

        for (int i = 0; i < diff.length; i++) {
            if(diff[i] > 0){
                profit+=diff[i];
            }
        }
        return profit;
    }
}
