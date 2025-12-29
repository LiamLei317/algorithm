package com.coding.bitManipulation.basic;

/**
 * 使两个整数相等的位更改次数
 * index:3226
 * <a href="https://leetcode.cn/problems/number-of-bit-changes-to-make-two-integers-equal/">...</a>
 */
public class MinChanges {

    public int minChanges_or(int n, int k) {
        return (n | k) != n ? -1 : Integer.bitCount(n ^ k);
    }

    public int minChanges_and(int n, int k) {
        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }

    public int minChanges_me(int n, int k) {
        if ((~n & k) > 0) {
            return -1;
        }
        return Integer.bitCount(n ^ k);
    }
}
