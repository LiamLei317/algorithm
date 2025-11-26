package com.coding.slideWindow.definiteLength;

import java.util.*;

/**
 * 几乎全唯一子数组的最大和
 * index:2841
 * <a href="https://leetcode.cn/problems/maximum-sum-of-an-almost-unique-subarray/description/">...</a>
 */
public class AlmostUniqueSubArray {

    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0; // 最终答案
        long sum = 0; // 当前窗口内的和
        Map<Integer, Integer> uniqueMap = new HashMap<>(); // 存储窗口内元素map， k=元素，v=出现次数
        for (int i = 0; i < nums.size(); i++) {
            Integer in = nums.get(i);
            // 入
            sum += in;
            uniqueMap.put(in, uniqueMap.getOrDefault(in, 0) + 1);
            // 是否形成窗口判断
            int left = i - k + 1;
            if (left < 0) {
                continue;
            }
            // 计算
            if (uniqueMap.size() >= m) {
                ans = Math.max(ans, sum);
            }
            // 出
            Integer out = nums.get(left);
            sum -= out;
            Integer cnt = uniqueMap.get(out);
            if (cnt == 1) {
                uniqueMap.remove(out);
            } else {
                uniqueMap.put(out, cnt - 1);
            }
        }
        return ans;
    }

}
