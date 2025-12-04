package com.coding.slideWindow.indefiniteLength;

import java.util.Arrays;

/**
 * 使数组平衡的最小移出数目
 * index:3634
 * <a href="https://leetcode.cn/problems/minimum-removals-to-balance-array/">...</a>
 */
public class MinRemoval {

    public int minRemoval(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);
        int ans = 0;
        for (int right = 0, left = 0; right < nums.length; right++) {
            // 使当前数组满足要求
            while (nums[right] > (long) k * nums[left]) {
                left++;
            }
            // 计算
            ans = Math.max(ans, right - left + 1);
        }
        return nums.length - ans;
    }

}
