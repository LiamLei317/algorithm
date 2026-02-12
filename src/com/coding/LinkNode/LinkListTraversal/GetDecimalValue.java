package com.coding.LinkNode.LinkListTraversal;

import com.coding.common.ListNode;

/**
 * 二进制链表转整数
 * index:1290
 * <a href="https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/">...</a>
 */
public class GetDecimalValue {

    public int getDecimalValue(ListNode head) {
       int ans = 0;
       while (head != null) {
           ans = ans * 2 + head.val;
           head = head.next;
       }
       return ans;
    }
}
