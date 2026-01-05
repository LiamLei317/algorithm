package com.coding.otherDataStruct.enumSkills.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * index:1
 * <a href="https://leetcode.cn/problems/two-sum/description/">...</a>
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(target - nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ans = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}
