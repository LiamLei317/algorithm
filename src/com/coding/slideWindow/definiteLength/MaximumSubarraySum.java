package com.coding.slideWindow.definiteLength;

import java.util.HashMap;
import java.util.Map;

/**
 * 长度为k的子数组中的最大和
 * index:2461
 * <a href="https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/">...</a>
 */
public class MaximumSubarraySum {

    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 入
            maxSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // 判断是否形成窗口
            int left = i - k + 1;
            if (left < 0) {
                continue;
            }
            // 计算
            if (map.size() == k) {
                ans = Math.max(ans, maxSum);
            }
            // 出
            maxSum -= nums[left];
            if (map.get(nums[left]) > 1) {
                map.put(nums[left], map.get(nums[left]) - 1);
            } else {
                map.remove(nums[left]);
            }
        }
        return ans;
    }
}
