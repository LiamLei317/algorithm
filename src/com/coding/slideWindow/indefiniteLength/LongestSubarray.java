package com.coding.slideWindow.indefiniteLength;

/**
 * 删掉一个元素以后全为1的最长子数组
 * index:1493
 * <a href="https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/">...</a>
 */
public class LongestSubarray {

    /**
     * 关键逻辑
     * 这道题等价于滑动窗口中 0 的个数不超过1的窗口的最大长度
     * 这么去想的话和 3090 那道题几乎一模一样了
     */
    public int longestSubarray(int[] nums) {
        int zeroCnt = 0, ans = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCnt++;
            }
            if (zeroCnt > 1) {
                while (zeroCnt > 1) {
                    if (nums[left] == 0) {
                        zeroCnt--;
                    }
                    left++;
                }
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
        // [0,1,1,1,0,1,1,0,1]
    }
}
