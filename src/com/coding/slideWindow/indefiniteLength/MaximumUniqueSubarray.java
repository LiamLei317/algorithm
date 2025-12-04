package com.coding.slideWindow.indefiniteLength;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 删除子数组的最大得分
 * index:1695
 * <a href="https://leetcode.cn/problems/maximum-erasure-value/">...</a>
 */
public class MaximumUniqueSubarray {

    /**
     * 也就是求连续不同子数组的和最大值
     */
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0, sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int left = 0, right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maximumUniqueSubarray_better(int[] nums) {
        int ans = 0;
        int sum = 0;
        int max = Arrays.stream(nums).max().orElse(10000);
        int[] cnt = new int[max + 1];
        for (int left = 0, right = 0; right < nums.length; right++) {
            while (cnt[nums[right]] == 1) {
                cnt[nums[left]] = 0;
                sum -= nums[left];
                left++;
            }
            cnt[nums[right]] = 1;
            sum += nums[right];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
