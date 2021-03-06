package io.sasoribi.algorithm.calculate;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */
public class BestTimeSellStock {
    //121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int max = 0;
        int ans = 0;
        
        for (int i = prices.length - 1 ; i >= 0; i--) {
            if(max == 0) {
                max = prices[i];
                continue;
            }
            
            // 变更当前最大值
            if(max < prices[i]){
                max = prices[i];
            }
            
            // 模拟只有一个element的单调栈
            if(max > prices[i]
                    && max - prices[i] > ans){
                // 计算利润
                ans = max - prices[i];
            }
        }
        return ans;
    }
}
