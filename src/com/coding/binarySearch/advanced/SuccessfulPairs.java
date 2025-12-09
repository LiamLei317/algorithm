package com.coding.binarySearch.advanced;

import java.util.Arrays;

/**
 * 咒语和药水的成功对数
 * index:2300
 * <a href="https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/">...</a>
 */
public class SuccessfulPairs {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = potions.length;
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            ans[i] = n - lowerBound(potions, (success + spells[i] - 1) / spells[i]);
        }
        return ans;
    }

    public int lowerBound(int[] nums, long target) {
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
