package com.coding.slideWindow.definiteLength;

import java.util.Arrays;

/**
 * 半径为k的子数组的平均数
 * index:2090
 * <a href="https://leetcode.cn/problems/k-radius-subarray-averages/description/">...</a>
 */
public class GetRadiusAvg {

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        long sum = 0; // 本题的取值范围很大，sum可能会超限
        for (int i = 0; i < n; i++) {
            // 入
            sum += nums[i];
            // 判断是否形成窗口
            if (i < k * 2) { // i - k * 2 + 1 - 1 > 0
                continue;
            }
            // 计算
            ans[i - k] = (int) (sum / (k * 2 + 1)); // 平均值赋值给圆心
            // 出
            sum -= nums[i - k * 2];
        }
        return ans;
    }
}
