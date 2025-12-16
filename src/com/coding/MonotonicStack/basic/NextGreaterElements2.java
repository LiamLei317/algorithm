package com.coding.MonotonicStack.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 下一个更大元素II
 * index:503
 * <a href="https://leetcode.cn/problems/next-greater-element-ii/description/">...</a>
 */
public class NextGreaterElements2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        // 下一个更大元素单调栈
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 循环范围 2n，模拟数组延长
        for (int i = 0; i < 2 * n; i++) {
            // 找到模拟延长的数组元素在原数组的位置
            int index = i % n;
            while (!deque.isEmpty() && nums[deque.peek()] < nums[index]) {
                ans[deque.pop()] = nums[index];
            }
            // 大于 n 的数据是模拟的，没必要 push
            if (i < n) {
                deque.push(index);
            }
        }
        return ans;
    }
}
