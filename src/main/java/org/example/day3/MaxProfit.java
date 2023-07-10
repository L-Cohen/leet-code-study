package org.example.day3;

/**
 * @author ryf
 * @version 1.0
 * @project leecode-study
 * @description 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润
 * @date 2023/6/29
 */
public class MaxProfit {
    /**
     * 遍历数组从下标1开始到length -1，计算当前值 - 上一个值是否大于0，大于则加入sale中（防止下标越界）
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sale = 0;
        for (int i = 1; i <= prices.length - 1; i++) {
            int res = prices[i] - prices[i - 1];
            if (res > 0) {
                sale += res;
            }
        }
        return sale;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit1(prices));

    }

}
