package com.coding.MonotonicStack.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElements2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] leftBigger = new int[n];
        int[] rightBigger = new int[n];
        Arrays.fill(leftBigger, -1);
        Arrays.fill(rightBigger, -1);
        Deque<Integer> stackRight = new ArrayDeque<>();
        Deque<Integer> stackLeft = new ArrayDeque<>();
        for (int left = 0; left < n; left++) {
            // 同时计算两个栈
            int right = n - left - 1;

        }
        return nums;
    }
}
