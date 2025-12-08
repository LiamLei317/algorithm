package com.coding.binarySearch;

public class MaximumCount {

    public int maximumCount(int[] nums) {
        // 找到第一个大于等于 0 的索引
        int i = lowerBound(nums, 0);
        // 找到第一个大于 0 的索引
        int j = lowerBound(nums, 1);
        return Math.max(i, nums.length - j);
    }

    public int lowerBound(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
