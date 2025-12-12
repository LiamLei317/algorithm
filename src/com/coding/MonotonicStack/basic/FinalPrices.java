package com.coding.MonotonicStack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 商品折扣后的最终价格
 * index:1475
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/description/">...</a>
 */
public class FinalPrices {


    /**
     * 从左考虑
     * 数组模拟栈
     */
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        int[] stack = new int[prices.length];
        // 哨兵
        int top = -1;
        for (int i = 0; i < prices.length; i++) {
            while (top >= 0 && prices[stack[top]] >= prices[i]) {
                int j = stack[top--]; // 栈顶元素指针
                ans[j] = prices[j] - prices[i];
            }
            stack[++top] = i;
        }
        // 原价处理
        while (top >= 0) {
            ans[stack[top]] = prices[stack[top]];
            top--;
        }
        return ans;
    }

    /**
     * 从右往左
     * 有哨兵
     */
    public int[] finalPrices_right_sentinel(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        // 哨兵
        stack.push(0);
        for (int i = prices.length - 1; i >= 0; i--) {
            while (stack.peek() > prices[i]) {
                // 栈顶大于当前元素就出栈
                stack.pop();
            }
            ans[i] = prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }

    /**
     * 从右往左
     * 无哨兵
     */
    public int[] finalPrices_right_no(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                // 栈顶大于当前元素就出栈
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - prices[stack.peek()];
            stack.push(i);
        }
        return ans;
    }
}
