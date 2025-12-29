package com.coding.monotonicStack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * index:739
 * <a href="https://leetcode.cn/problems/daily-temperatures/description/">...</a>
 */
public class DailyTemperatures {

    /**
     * 用数组模拟栈-从左考虑
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // 单调栈
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[stack[top]] < temperatures[i]) {
                // 下面两行不能融合成一行
                int j = stack[top--];
                ans[j] = i - j;
            }
            // 当前元素下标入栈
            stack[++top] = i;
        }
        return ans;
    }

    /**
     * 从左边开始考虑
     */
    public int[] dailyTemperatures_left(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 如果当前元素大于栈顶元素，说明栈顶元素的下一个更大元素出现了，出栈记录
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            // 当前元素下标入栈
            stack.push(i);
        }
        return ans;
    }

    /**
     * 从右到左考虑
     */
    public int[] dailyTemperatures_right(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            // 弹出栈中比当前元素小或相等的元素
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}
