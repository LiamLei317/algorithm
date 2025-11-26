package com.coding.slideWindow.definiteLength;

import java.util.Set;

/**
 * 给定字符串的固定子串的最大元音数
 * index:1456
 * <a href="https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/">...</a>
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        int ans = 0, vowels = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 入，更新标量
            if (set.contains(chars[i])) {
                vowels++;
            }
            // 判断是否形成窗口
            int left = i - k + 1;
            if (left < 0) {
                continue;
            }
            // 更新答案
            ans = Math.max(ans, vowels);
            if (ans == k) {
                return ans;
            }
            // 出，更新标量
            if (set.contains(chars[left])) {
                vowels--;
            }
        }
        return ans;
    }


    /**
     * 自己写的
     */
    public int maxVowels_me_1(String s, int k) {
        int ans = 0, vowels = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                vowels++;
            }
            if (i < k) {
                // 还没形成窗口
                ans = Math.max(ans, vowels);
                continue;
            }
            if (set.contains(chars[i - k])) {
                vowels--;
            }
            ans = Math.max(ans, vowels);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxVowels().maxVowels("a", 1));
    }
}
