package com.coding.slideWindow.indefiniteLength;

import java.util.Arrays;

/**
 * 将 x 减到0 的最小操作数
 * index:1658
 * <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/">...</a>
 */
public class MinOperations {

    /**
     * 逆向思维，维护一个滑动窗口，窗口内元素和为 sum - x
     * 和定长滑动窗口不同的是，这题需要通过判断窗口元素和的大小来判断是否需要移动窗口
     */
    public int minOperations(int[] nums, int x) {
        // 窗口内元素和为 sum - x
        int operationSum = Arrays.stream(nums).sum() - x;
        int ans = -1, currentSum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (left < nums.length && currentSum > operationSum) { // 窗口元素超预算，移动窗口左边界
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == operationSum) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans == -1 ? -1 : nums.length - ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        new MinOperations().minOperations(nums, 5);
    }
}
