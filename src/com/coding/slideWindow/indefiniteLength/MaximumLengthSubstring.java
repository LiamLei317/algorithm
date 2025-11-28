package com.coding.slideWindow.indefiniteLength;

import java.util.HashMap;
import java.util.Map;

/**
 * 每个字符最多只出现两次的最长子串
 * index:3090
 * <a href="https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/">...</a>
 */
public class MaximumLengthSubstring {

    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int currentLength = 0;
        Map<Character, Integer> map = new HashMap<>(); // 当前窗口内字符及其出现次数
        Map<Character, Integer> indexMap = new HashMap<>(); // 当前窗口内字符第一次出现的索引
        char[] chars = s.toCharArray();
        for (int i = 0, j = 0; j < chars.length; j++) {
            Integer rightCnt = map.get(chars[j]);
            // 右边窗口值未出现过或窗口内该字符出现频率小于2直接操作
            if (rightCnt == null || rightCnt < 2) {
                map.put(chars[j], rightCnt == null ? 1 : rightCnt + 1);
                if (rightCnt == null) {
                    indexMap.put(chars[j], j);
                }
                currentLength = j - i + 1;
                ans = Math.max(ans, currentLength);
                continue;
            }
            // 否则更新窗口左边界
            i = indexMap.get(chars[j]) + 1;
            // 更新第一次出现的字符索引
            int index = i;
            while (chars[index] != chars[j]) {
                index++;
            }
            indexMap.put(chars[j], index);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "dcfdddccb";
        System.out.println(new MaximumLengthSubstring().maximumLengthSubstring(s));
    }
}
