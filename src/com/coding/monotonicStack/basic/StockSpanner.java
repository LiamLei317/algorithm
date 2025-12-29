package com.coding.monotonicStack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 股票价格跨度
 * index:901
 * <a href="https://leetcode.cn/problems/online-stock-span/">...</a>
 */
public class StockSpanner {

    /**
     * 要找小于等于当前元素的股票价格，就是需要找到上一个比自己严格大的元素，所以要记录价格和价格的日期
     */
    private Deque<int[]> deque;

    /**
     * 当前日期
     */
    private int currentDay;

    /**
     * 初始化类的变量，此方法测试的时候一个case只会调用一次，后面都是复用类，否则没法实现需求了
     */
    public StockSpanner() {
        deque = new ArrayDeque<>();
        currentDay = -1;
    }

    public int next(int price) {
        currentDay++; // 当前日期自增
        while (!deque.isEmpty() && deque.peek()[0] <= price) {
            deque.pop();
        }
        int span = deque.isEmpty() ? currentDay + 1 : currentDay - deque.peek()[1];
        deque.push(new int[] { price, currentDay}); // 当前元素入栈
        return span;
    }
}
