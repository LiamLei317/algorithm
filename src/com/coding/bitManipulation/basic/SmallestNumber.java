package com.coding.bitManipulation.basic;

/**
 * 仅含置位位的最小整数
 * index:3370
 * <a href="https://leetcode.cn/problems/smallest-number-with-all-set-bits/">...</a>
 */
public class SmallestNumber {

    public int smallestNumber(int pattern) {
        return (1 << (32 - Integer.numberOfLeadingZeros(pattern))) - 1;
    }
}
