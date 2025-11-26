package com.coding.slideWindow.definiteLength;

/**
 * 给定数组的定长子数组最大平均数
 * index:643
 * <a href="https://leetcode.cn/problems/maximum-average-subarray-i/description/">...</a>
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 入，统计和
            sum += nums[i];
            // 判断是否形成窗口
            if (i - k + 1 < 0) {
                continue;
            }
            // 计算和
            maxSum = Math.max(maxSum, sum);
            // 出，更新和
            sum -= nums[i - k + 1];
        }
        return (double) maxSum / k;
    }
}
