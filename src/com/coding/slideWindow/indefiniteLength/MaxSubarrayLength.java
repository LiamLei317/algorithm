package com.coding.slideWindow.indefiniteLength;

import java.util.HashMap;
import java.util.Map;

/**
 * 最多K个重复元素的最长子数组
 * index:2958
 * <a href="https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/">...</a>
 */
public class MaxSubarrayLength {

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.get(nums[right]) > k) {
                map.merge(nums[left], -1, Integer::sum);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
