package com.coding.monotonicStack.basic;

import java.util.*;

/**
 * 车队
 * index:853
 * <a href="https://leetcode.cn/problems/car-fleet/description/">...</a>
 */
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        // 构建地点和时间的 map，注意，速度是 double，不然由于取整可能会导致精度丢失答案错误
        Map<Integer, Double> timeMap = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            timeMap.put(position[i], (double) (target - position[i]) / speed[i]);
        }
        // 对起始地点排序，这样在判断是否可以追上的时候天然就满足了位置更远的判断条件
        Arrays.sort(position);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int j : position) {
            double curTime = timeMap.get(j);
            // 位置更近但是耗时更多，就意味着会被之前的车追上，把能追上的车弹出栈，栈中剩下的车就都是追不上的
            while (!stack.isEmpty() && curTime >= timeMap.get(stack.peek())) {
                stack.pop();
            }
            stack.push(j);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] position = {4, 6};
        int[] speed = {3, 2};
        int target = 10;
        System.out.println(new CarFleet().carFleet(target, position, speed));
    }
}
