package com.coding.binarySearch.advanced;

import java.util.Arrays;

/**
 * 两个数组间的距离值
 * index:1385
 * <a href="https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/">...</a>
 */
public class FindTheDistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        Arrays.sort(arr2);
        for (int num : arr1) {
            int index = findTheDistanceValue(arr2, num - d);
            if (index == arr2.length || arr2[index] > num + d) {
                ans++;
            }
        }
        return ans;
    }

    public int findTheDistanceValue(int[] arr2, int target) {
        int left = -1, right = arr2.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr2[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
