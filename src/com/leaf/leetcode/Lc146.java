package com.leaf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2020/5/26
 */
public class Lc146 {


    public static void main(String[] args) {
        Lc146 lc146 = new Lc146(1);

        lc146.put(1, 1);
        lc146.put(2, 2);
        System.out.println(lc146.get(1));

    }


    Map<Integer, Node> map;

    class Node {

        /**
         * 后节点
         */
        private Node next;
        /**
         * 前节点
         */
        private Node pre;
        private int key;
        private int value;
    }

    private Node head;
    private Node tail;
    int capacity;

    public Lc146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity * 2);

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            //移动该节点到头节点
            mobileHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //新节点
        if (node == null) {
            addHead(key, value);
            //清除尾结点
            if (map.size() > capacity) {
                removeLast();
            }
        } else {
            node.value = value;
            //将该节点移动到头结点
            mobileHead(node);
        }
    }

    private void removeLast() {
        map.remove(tail.pre.key);
        tail.pre = tail.pre.pre;
        tail.pre.pre.next = tail;
    }


    private void addHead(int key, int value) {
        //构建新节点 放入链表头
        Node temp = new Node();
        temp.key = key;
        temp.value = value;

        Node temp1 = head.next;

        head.next = temp;
        temp.next = temp1;
        temp1.pre = temp;
        temp.pre = head;
        //写入数据
        map.put(key, head);
    }


    private void mobileHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        temp.pre = node;
        node.pre = head;
    }

}
