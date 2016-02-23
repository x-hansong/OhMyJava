package com.medium;

/**
 * Created by xhans on 2016/2/23.
 */
public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length != 0) {
            int own = prices[0];
            int i;
            //买入第一个最低点
            for (i = 1; i < prices.length && prices[i - 1] >= prices[i]; i++) {
                own = prices[i];
            }
            for (; i < prices.length; i++) {
                //已经到最后一天，如果还有股票价高就卖
                if (i == prices.length - 1) {
                    if (own != -1) {
                        if (own < prices[i]) {
                            profit += prices[i] - own;
                        }
                    }
                } else {
                    if (own != -1) {
                        //在极高点卖
                        if (prices[i] > own && prices[i] > prices[i + 1]) {
                            profit += prices[i] - own;
                            own = -1;
                        }
                    } else {
                        //在极低点买
                        if (prices[i - 1] >= prices[i] && prices[i] < prices[i + 1]) {
                            own = prices[i];
                        }
                    }
                }
            }
        }
        return profit;
    }
    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
