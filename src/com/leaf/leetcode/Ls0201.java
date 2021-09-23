package com.leaf.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2020/6/26
 */
public class Ls0201 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next = new ListNode(1);
        ListNode ls = new Ls0201().removeDuplicateNodes(listNode);
        System.out.println(ls);
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> valSet = new HashSet<>();
        ListNode temp = head;
        ListNode pre = head;
        while (temp != null) {
            if (valSet.contains(temp.val)) {
                pre.next = temp.next;
            } else {
                valSet.add(temp.val);
                pre = temp;
            }
            //当前节点就是下个节点的前置节点

            temp = temp.next;
        }
        return head;
    }
}
