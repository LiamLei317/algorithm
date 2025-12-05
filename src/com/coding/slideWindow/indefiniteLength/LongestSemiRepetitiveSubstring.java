package com.coding.slideWindow.indefiniteLength;

/**
 * 找到最长的半重复子串
 * index:2730
 * <a href="https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/">...</a>
 */
public class LongestSemiRepetitiveSubstring {

    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 1, samePairCnt = 0;
        char[] chars = s.toCharArray();
        for (int left = 0, right = 1; right < s.length(); right++) {
            if (chars[right] == chars[right - 1]) {
                samePairCnt++;
            }
            while (samePairCnt > 1) {
                if (chars[left] == chars[left + 1]) {
                    samePairCnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return  ans;
    }
}
