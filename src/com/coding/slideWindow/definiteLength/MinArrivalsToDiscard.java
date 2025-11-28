package com.coding.slideWindow.definiteLength;

import java.util.HashMap;
import java.util.Map;

/**
 * 使库存平衡的最少丢弃次数
 * index:3679
 * <a href="https://leetcode.cn/problems/minimum-discards-to-balance-inventory/">...</a>
 */
public class MinArrivalsToDiscard {

    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int discard = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrivals.length; i++) {
            // 先判断是否需要丢弃再入
            Integer cnt = map.get(arrivals[i]);
            if (cnt != null && cnt == m) {
                // 丢弃当前数据
                arrivals[i] = -1;
                discard++;
            } else {
                // 否则计数 + 1
                map.put(arrivals[i], cnt == null ? 1 : cnt + 1);
            }
            // 判断是否形成窗口
            int left = i - w + 1;
            if (left < 0) {
                continue;
            }
            // 出
            if (arrivals[left] != -1) {
                if (map.get(arrivals[left]) == 1) {
                    map.remove(arrivals[left]);
                } else {
                    map.put(arrivals[left], map.get(arrivals[left]) - 1);
                }
            }
        }
        return discard;
    }

    public static void main(String[] args) {
        int[] arrivals = {1, 2, 3, 3, 3, 4};
        int w = 3;
        int m = 2;
    }
}
