package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/26
 */
public class Lc23 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        new Lc23().mergeKLists(new ListNode[]{l1, l2, l3});


    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ln = null;
        ListNode head = null;
        int min = 0;
        while (!isEmpty(lists)) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[min] == null && lists[i] != null) {
                    min = i;
                } else if (lists[i] != null && lists[i].val < lists[min].val) {
                    min = i;
                }
            }
            if (ln == null) {
                ln = lists[min];
                head = lists[min];
            } else {
                ln.next = lists[min];
                ln = lists[min];
            }
            lists[min] = lists[min].next;
        }
        return head;

    }

    private boolean isEmpty(ListNode[] lists) {
        boolean isEmpty = true;
        for (ListNode ln : lists) {
            if (ln != null) {
                return false;
            }
        }
        return isEmpty;
    }
}
