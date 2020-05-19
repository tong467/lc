package com.leaf.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2020/5/16
 */
public class Lc25 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        new Lc25().reverseKGroup(head, 2);

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        //获得第一次k个反转的链表
        ListNode[] kHeadArray = getReverseK(head, k);
        //获得这个新链表的最后一个
        ListNode last = getLast(kHeadArray[0]);
        //获得剩余链表
        head = kHeadArray[1];
        while (head != null) {
            //再次获得k个反转链表
            ListNode[] tempKHeadArray = getReverseK(head, k);
            //获得剩余链表
            head = tempKHeadArray[1];
            //将链表拼接回新链表
            last.next = tempKHeadArray[0];
            //获得这个新链表的最后一个
            last = getLast(tempKHeadArray[0]);
        }
        return kHeadArray[0];
    }

    /**
     * 获得链表最后一个元素
     * @param head
     * @return
     */
    private ListNode getLast(ListNode head) {
        ListNode tempHead = head;

        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }
        return tempHead;
    }

    /**
     * 获取链表前K个元素的反转链表
     * @param head 原链表
     * @param k 数字K
     * @return ListNode数据组 0 新链表头节点 1 原链表剩余部分。2 新链表尾节点
     */
    private ListNode[] getReverseK(ListNode head, int k) {
        ListNode newHead = null;
        int i = 0;
        while (head != null) {
            //存储指针
            ListNode tempHead = head;
            //原链表指针下移
            head = head.next;
            //分离原链接头并将next 节点 指向新链表头
            tempHead.next = newHead;
            //更新新链表头；
            newHead = tempHead;
            i++;
            if (i == k) {
                return new ListNode[]{
                        newHead, head
                };
            }
        }
        //如果执行到这说明剩余的节点不够，要将链表再次反转；
        ListNode newHead1 = null;
        while (newHead != null) {
            //存储指针
            ListNode tempHead = newHead;
            //原链表指针下移
            newHead = newHead.next;
            //分离原链接头并将next 节点 指向新链表头
            tempHead.next = newHead1;
            //更新新链表头；
            newHead1 = tempHead;
        }
        return new ListNode[]{
                newHead1, null
        };
    }


}
