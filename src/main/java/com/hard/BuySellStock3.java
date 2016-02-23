package com.hard;

/**
 * Created by xhans on 2016/2/23.
 */
public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        int profits = 0;
        if (prices.length != 0) {
            int[] leftMaxProfits = new int[prices.length];

            int min = Integer.MAX_VALUE;
            leftMaxProfits[0] = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                leftMaxProfits[i] = Math.max(leftMaxProfits[i], prices[i] - min);
            }

            int rightMaxProfit = 0;
            int max = 0;
            profits = leftMaxProfits[prices.length - 1];
            for (int i = prices.length - 1; i >= 0; i--) {
                max = Math.max(max, prices[i]);
                rightMaxProfit = Math.max(rightMaxProfit, max - prices[i]);
                profits = Math.max(profits, rightMaxProfit + leftMaxProfits[i]);
            }
        }
        return profits;
    }
}
