package com.coding.slideWindow.indefiniteLength;

/**
 * 最大连续1的个数III
 * index:1004
 * <a href="https://leetcode.cn/problems/max-consecutive-ones-iii/">...</a>
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int ans = 0, zeroCnt = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCnt++;
            while (zeroCnt > k) {
                if (nums[left] == 0) zeroCnt--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
