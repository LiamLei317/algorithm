package com.coding.slideWindow.indefiniteLength;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子串的长度
 * index:3
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">...</a>
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(); // 记录当前出现的不重复字符及其索引
        int ans = 0;
        int currentLen = 0;
        for (int i = 0, j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (map.containsKey(c) && map.get(c) >= i) {
                i = map.get(c) + 1; // 窗口左边从重复字符的索引的下一位开始
                map.put(c, j); // 重复字符索引更新为当前索引
                continue;
            }
            map.put(c, j);
            currentLen = j - i + 1;
            ans = Math.max(ans, currentLen);
        }
        return ans;
    }
}
