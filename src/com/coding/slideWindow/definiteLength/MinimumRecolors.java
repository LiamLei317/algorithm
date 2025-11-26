package com.coding.slideWindow.definiteLength;

/**
 * 得到 K 个黑块的最少涂色次数
 * index:2379
 * <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/">...</a>
 */
public class MinimumRecolors {


    public int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE; // 最终答案，记录当前最小操作数
        int wCnt = 0; // 当前窗口内的白色块数
        char[] chars = blocks.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 入
            if (chars[i] == 'W') {
                wCnt++;
            }
            // 判断是否形成窗口
            if (i - k + 1 < 0) {
                continue;
            }
            // 计算
            ans = Math.min(ans, wCnt);
            // 出
            if (chars[i - k + 1] == 'W') {
                wCnt--;
            }
        }
        return ans;
    }
}
