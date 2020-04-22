package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2019/12/16
 */
public class Lc160 {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next =  headA.next;
//        headB.next.next = new ListNode(1);
//        headB.next.next.next = new ListNode(8);
//        headB.next.next.next.next = new ListNode(4);
//        headB.next.next.next.next.next = new ListNode(5);
        new Lc160().getIntersectionNode(headA, headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int i =0;
        do{
            if (tempA==tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA==null){
                tempA = headB;
                i++;
            }
            if(tempB==null){
                tempB = headA;
                i++;
            }
            if (tempA==tempB){
                return tempA;
            }
        } while(tempA!=tempB&&i<2);
        return null;
    }


//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode tempA = headA;
//        ListNode tempB = headB;
//        do {
//            if (tempA == tempB) {
//                return tempA;
//            }
//
//            tempA = tempA.next;
//            tempB = tempB.next;
//            if (tempA == null && tempB == null) {
//                return null;
//            }
//            if (tempA == null) {
//                tempA = headB;
//
//            }
//            if (tempB == null) {
//                tempB = headA;
//
//            }
//        } while (tempA != tempB);
//        return tempA;
//    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode rHeadA = reverse(headA);
//        ListNode tHeadA = rHeadA;
//        ListNode rHeadB = reverse(headB);
//        ListNode tHeadB = rHeadB;
//        while(rHeadA!=null && rHeadB!=null && rHeadA.next!=null  &&rHeadB.next!=null && rHeadA.val==rHeadB.val){
//            rHeadA = rHeadA.next;
//            rHeadB = rHeadB.next;
//        }
//        ListNode temp = null;
//        if(rHeadA!=null){
//            temp = rHeadA;
//        }
//        if(rHeadB!=null){
//            temp = rHeadB;
//        }
//        headA = reverse(tHeadA);
//        headB = reverse(tHeadB);
//        return temp.next;
//    }
//
//    private ListNode reverse(ListNode listNode){
//        ListNode head = null;
//        while(listNode!=null){
//            ListNode temp = listNode.next;
//            listNode.next = head;
//            head = listNode;
//            listNode = temp;
//        }
//        return head;
//    }
}
