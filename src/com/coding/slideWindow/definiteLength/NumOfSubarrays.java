package com.coding.slideWindow.definiteLength;

/**
 * 大小为k且平均值大于等于阈值的子数组数目
 * index:1343
 */
public class NumOfSubarrays {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // 这样只用计算和不用计算平均值
        int thresholdSum = k * threshold;
        int sum = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            // 入，统计和
            sum += arr[i];
            // 判断是否形成窗口
            if (i - k + 1 < 0) {
                continue;
            }
            // 更新答案
            if (sum >= thresholdSum) {
                ans++;
            }
            // 出，更新和
            sum -= arr[i - k + 1];
        }
        return ans;
    }
}
