package com.coding.otherDataStruct.enumSkills.advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * 总持续时间可以被 60 整除的歌曲
 * index:1010
 * <a href="https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/">...</a>
 */
public class NumPairsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] index = new int[60];
        int ans = 0;
        for (int i = 0; i < time.length; i++) {
            int rem = time[i] % 60;
            // 如果 rem 是 20，target 就是 40
            // 如果 rem 是 0，target 应该是 0 (而不是 60)
            // 使用 (60 - rem) % 60 可以完美处理 0 的情况
            ans += index[(60 - rem) % 60];
            index[rem]++;
        }
        return ans;
    }
}
