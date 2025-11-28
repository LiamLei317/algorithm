package com.coding.slideWindow.definiteLength;

/**
 * 爱生气的书店老板
 * index:1052
 * <a href="https://leetcode.cn/problems/grumpy-bookstore-owner/">...</a>
 */
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int n = customers.length;
        // 先计算没有抑制情绪时满意的顾客的数量
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
            }
        }
        int max = 0; // 抑制情绪最大收益
        int current = 0; // 当前窗口内抑制情绪的收益
        for (int i = 0; i < n; i++) {
            // 入
            if (grumpy[i] == 1) {
                current += customers[i];
            }
            // 窗口判断
            int left = i - minutes + 1;
            if (left < 0) {
                continue;
            }
            // 更新最大收益
            max = Math.max(max, current);
            // 出
            if (grumpy[left] == 1) {
                current -= customers[left];
            }
        }
        return ans + max;
    }
}
