package com.coding.slideWindow.definiteLength;

/**
 * 可获得的最大点数
 * index:1423
 * <a href="https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/">...</a>
 */
public class MaxScore {

    /**
     * 模版写法，需要额外判断一下 k == n 的情况
     */
    public int maxScore(int[] cardPoints, int k) {
        int minSum = 0;
        int m = cardPoints.length - k;
        // 求第一个长度为 m 的数组的和
        for (int i = 0; i < m; i++) {
            minSum += cardPoints[i];
        }
        int ans = minSum;
        int total = minSum;
        for (int i = m; i < cardPoints.length; i++) {
            total += cardPoints[i];
            minSum += cardPoints[i] - cardPoints[i - m];
            ans = Math.min(ans, minSum);
        }
        return total - ans;
    }

}
