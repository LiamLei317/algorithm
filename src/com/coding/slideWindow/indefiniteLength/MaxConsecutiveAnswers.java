package com.coding.slideWindow.indefiniteLength;

/**
 * 考试的最大困扰度
 * index:2024
 * <a href="https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/">...</a>
 */
public class MaxConsecutiveAnswers {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] cnt = new int[2];
        int ans = 0;
        char[] chars = answerKey.toCharArray();
        for (int left = 0, right = 0; right < answerKey.length(); right++) {
            cnt[chars[right] >> 1 & 1]++;
            while (Math.min(cnt[0], cnt[1]) > k) {
                cnt[chars[left] >> 1 & 1]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int maxConsecutiveAnswers_my(String answerKey, int k) {
        int tCnt = 0, fCnt = 0;
        int ans = 0;
        char[] chars = answerKey.toCharArray();
        for (int left = 0, right = 0; right < answerKey.length(); right++) {
            if (chars[right] == 'T') {
                tCnt++;
            } else {
                fCnt++;
            }
            while (Math.min(tCnt, fCnt) > k) {
                if (chars[left] == 'T') {
                    tCnt--;
                } else {
                    fCnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
