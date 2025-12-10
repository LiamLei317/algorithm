package com.coding.binarySearch.advanced;

import java.util.Arrays;

/**
 * 和有限的最长子序列
 * index:2389
 * <a href="https://leetcode.cn/problems/longest-subsequence-with-limited-sum/">...</a>
 */
public class AnswerQueries {

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        // 排序 nums
        Arrays.sort(nums);
        // nums 前缀和处理
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        // 遍历 queries
        for (int i = 0; i < m; i++) {
            queries[i] = binarySearch(nums, queries[i]);
        }
        return queries;
    }

    public int binarySearch(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
           if (nums[mid] <= target) {
               left = mid;
           } else {
               right = mid;
           }
        }
        return right;
    }
}
