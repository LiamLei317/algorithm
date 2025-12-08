package com.coding.binarySearch.basic;

/**
 * 搜索插入位置
 * index:35
 * <a href="https://leetcode.cn/problems/search-insert-position/description/">...</a>
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
