package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/14
 */
public class Lc445 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = new Lc445().addTwoNumbers(l1, l2);
        System.out.println(l3.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;

        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;

        while (l1 != null || l2 != null) {

            int i1 = l1 != null ? l1.val : 0;
            int i2 = l2 != null ? l2.val : 0;
            int x = i1 + i2 + carry;
            carry = x / 10;
            ListNode current = new ListNode(x % 10);
            current.next = result;
            result = current;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry != 0) {
            ListNode current = new ListNode(carry);
            current.next = result;
            result = current;
        }
        return result;
    }

    public ListNode reverse(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }
}
