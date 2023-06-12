package org.example.day2;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 买卖股票的最佳时机
 * @date 2023/6/12
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 2, 5, 6, 1, 4};
        System.out.println(maxProfit(prices));
    }
}
