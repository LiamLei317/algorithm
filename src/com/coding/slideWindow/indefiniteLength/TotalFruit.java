package com.coding.slideWindow.indefiniteLength;

import java.util.HashMap;
import java.util.Map;

/**
 * 水果成篮
 * index:904
 * <a href="https://leetcode.cn/problems/fruit-into-baskets/">...</a>
 */
public class TotalFruit {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int ans = 0;
        for (int left = 0, right = 0; right < fruits.length; right++) {
            // 窗口右移，如果当前篮子右移后不满足条件，就清空某一个篮子
            if (basket.size() == 2 && !basket.containsKey(fruits[right])) {
                while (basket.size() == 2) {
                    if (basket.get(fruits[left]) == 1) {
                        basket.remove(fruits[left]);
                    } else {
                        basket.put(fruits[left], basket.get(fruits[left]) - 1);
                    }
                    left++;
                }
            }
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int totalFruit_merge(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int ans = 0;
        for (int left = 0, right = 0; right < fruits.length; right++) {
            basket.merge(fruits[right], 1, Integer::sum);
            while (basket.size() > 2) { // 不满足要求，窗口左移
                basket.merge(fruits[left], -1, Integer::sum);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]); // 离开窗口
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
