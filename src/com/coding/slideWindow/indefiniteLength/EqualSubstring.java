package com.coding.slideWindow.indefiniteLength;

/**
 * 尽可能使字符串相等
 * index:1208
 * <a href="https://leetcode.cn/problems/get-equal-substrings-within-budget/">...</a>
 */
public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int currentCost = 0, ans = 0;
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        for (int left = 0, right = 0; right < charsS.length; right++) {
            currentCost += Math.abs(charsS[right] - charsT[right]);
            while (currentCost > maxCost) {
                currentCost -= Math.abs(charsS[left] - charsT[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
