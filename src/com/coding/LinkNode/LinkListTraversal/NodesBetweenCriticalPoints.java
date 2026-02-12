package com.coding.LinkNode.LinkListTraversal;

import com.coding.common.ListNode;

/**
 * 找出临界点之间的最小和最大距离
 * index:2058
 * <a href="https://leetcode.cn/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/">...</a>
 */
public class NodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = Integer.MAX_VALUE, max = 0, preValue = -1, level = -1, firstX = -1, lastX = -1, xCnt = 0;
        while (head != null) {
            level++;
            // 第一个节点直接赋值继续
            if (level == 0) {
                preValue = head.val;
                head = head.next;
                continue;
            } else if (head.next == null) {
                head = null;
                continue;
            }
            // 判断是不是临界点
            int judgeFlag = (head.val - preValue) * (head.val - head.next.val);
            // 只有临界点才进行计算
            if (judgeFlag > 0) {
                xCnt++;
                if (lastX > 0) {
                    min = Math.min(min, level - lastX);
                    max = Math.max(max, level - firstX);
                } else if (firstX < 0) {
                    firstX = level;
                }
                lastX = level;
            }
            preValue = head.val;
            head = head.next;
        }
        return xCnt < 2 ? new int[]{-1, -1} : new int[]{min, max};
    }
}
