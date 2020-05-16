package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/1
 */
public class Lc21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //返回的头结点
        ListNode result = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //确定头结点
        if (l1.val < l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }
        //用于下移的指针
        ListNode temp = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        return result;
    }
}
