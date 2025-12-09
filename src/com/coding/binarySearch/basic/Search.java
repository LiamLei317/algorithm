package com.coding.binarySearch.basic;

/**
 * 二分查找
 * index:704
 * <a href="https://leetcode.cn/problems/binary-search/description/">...</a>
 */
public class Search {

    public int search(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

}
