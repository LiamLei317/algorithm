package com.coding.slideWindow.indefiniteLength;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 每个字符最多只出现两次的最长子串
 * index:3090
 * <a href="https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/">...</a>
 */
public class MaximumLengthSubstring {

    public int maximumLengthSubstring(String s) {
        int[] charCnt = new int[26]; // 代替 map 来记录当前字符出现的次数
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int left = 0, right = 0; right < chars.length; right++) {
            char c = chars[right];
            charCnt[c - 'a']++;
            while (charCnt[c - 'a'] > 2) {
                charCnt[chars[left] - 'a']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     * 关键逻辑
     * 用队列维护符合要求的字符串
     */
    public int maximumLengthSubstring_one(String s) {
        Queue<Character> queue = new LinkedList<>(); // 用队列来维护当前的窗口
        int[] charCnt = new int[26]; // 代替 map 来记录当前字符出现的次数
        char[] chars = s.toCharArray();
        int ans = 0;
        for (char c : chars) {
            int index = c - 'a';
            if (charCnt[index] < 2) {
                // 记录自增
                charCnt[index]++;
            } else {
                // 队列循环出队直到当前字符也出去一个
                while (queue.peek() != c) {
                    charCnt[queue.poll() - 'a']--;
                }
                queue.poll(); // 和当前字符一样的字符出队
            }
            queue.offer(c); // 当前字符入队
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "dcfdddccb";
        System.out.println(new MaximumLengthSubstring().maximumLengthSubstring(s));
    }
}
