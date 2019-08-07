package lc;

public class LC9 {
    private int maxProfit(int[] prices) {
        int max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            max_profit += Math.max(max_profit, max_profit + prices[i-1] - prices[i]);
        }

        return max_profit;
    }

    public static void main(String[] args) {
            // 7,1,5,4,6,3

    }

}
