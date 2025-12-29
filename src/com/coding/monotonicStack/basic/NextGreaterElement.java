package com.coding.monotonicStack.basic;

import java.util.*;

/**
 * 下一个更大元素I
 * index:496
 * <a href="https://leetcode.cn/problems/next-greater-element-i/">...</a>
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 做一个 nums2 的下一个更大元素的 Map
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        // 构建 nums2 的下一个更大元素 map，没有就是 -1
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

}
