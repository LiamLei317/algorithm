package com.coding.binarySearch.basic;

/**
 * 二分查找
 * index:704
 * <a href="https://leetcode.cn/problems/binary-search/">...</a>
 */
public class Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right != nums.length && nums[right] != target ? -1 : right;
    }
}
