package com.coding.binarySearch.basic;

import java.util.Arrays;

/**
 * 查找排序数组中某个数字的第一个和最后一个的位置
 * index:34
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">...</a>
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        // 找到第一个符合要求的数字
        int start = findIndexBothOpen(nums, target);
        // start == nums.length 说明所有元素都小于 target
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        // 如果 start 存在意味着 end 一定存在
        int end = findIndexBothOpen(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    // 开区间
    public int findIndexBothOpen(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }  else {
                left = mid;
            }
        }
        return right;
    }

    // 左闭右开区间
    public int findIndexRightOpen(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }  else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 找到满足条件的第一个数字的下表，如果所有的数字都小于 target 就返回数组长度
    public int findIndex(int[] nums, int target) {
        // 闭区间
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
