package com.coding.binarySearch.advanced;

import java.util.Arrays;

/**
 * 比较字符串最小字母出现频次
 * index:1170
 * <a href="https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/">...</a>
 */
public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int m = queries.length, n = words.length;
        // 求出 words 的频次
        int[] freq = new int[n];
        // 做出频次数组
        for (int i = 0; i < n; i++) {
            freq[i] = freq(words[i]);
        }
        // 升序排序
        Arrays.sort(freq);
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            // 找到第一个大于等于 target 的元素
            int index = binarySearch(freq, freq(queries[i]));
            if (index == 0) { // 特殊处理频次为 1 的情况
                ans[i] = 1;
            } else {
                ans[i] = n - index;
            }
        }
        return ans;
    }

    public int freq(String str) {
        int ans = 0;
        char cur = str.charAt(0);
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c < cur) {
                cur = c;
                ans = 1;
            } else if (c == cur){ // 千万不能直接 else，不然 ans 偏大
                ans++;
            }
        }
        return ans;
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

    public static void main(String[] args) {
        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};
        System.out.println(new NumSmallerByFrequency().numSmallerByFrequency(queries, words));
    }

}
