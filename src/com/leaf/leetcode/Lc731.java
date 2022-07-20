package com.leaf.leetcode;

import java.util.*;

public class Lc731 {

    public static void main(String[] args) {
//["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book"]
//[[],[24,40],[43,50],[27,43],[5,21],[30,40],[14,29],[3,19],[3,14],[25,39],[6,19]]
        MyCalendarTwo MyCalendar = new MyCalendarTwo();
        System.out.println(MyCalendar.book(24, 40)); // returns true
        System.out.println(MyCalendar.book(43, 50)); // returns true
        System.out.println(MyCalendar.book(27, 43)); // returns true
        System.out.println(MyCalendar.book(5, 21)); // returns false
        System.out.println(MyCalendar.book(30, 40)); // returns true
        System.out.println(MyCalendar.book(25, 55)); // returns true

    }
}

class MyCalendarTwo {

    List<List<Integer>> timeAxis = new ArrayList<>();

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        List<Integer> node = new ArrayList<>();
        //空的，或者在头， 或者在尾部
        if (timeAxis.isEmpty() || end < timeAxis.get(0).get(0) || start > timeAxis.get(timeAxis.size() - 1).get(1)) {
            Collections.addAll(node, start, end);
            timeAxis.add(node);
        } else {
            for (int i = 0; i < timeAxis.size(); i++) {
                List<Integer> tempNode = timeAxis.get(i);
                if (start > tempNode.get(1)) {
                    continue;
                } else if (end < tempNode.get(0)) {
                    Collections.addAll(node, start, end);
                    timeAxis.add(node);
                    break;
                } else {
                    //开始有交叉进行三重预定判断
                    int j = start;

                    for (; j < end; j++) {
                        int cf = 1;
                        for (int k = i; k < timeAxis.size(); k++) {
                            List<Integer> tempNode2 = timeAxis.get(k);
                            if (j >= tempNode2.get(0) && j < tempNode2.get(1)) {
                                cf++;
                            }
                        }
                        if (cf == 3) {
                            return false;
                        }
                    }
                    Collections.addAll(node, start, end);
                    timeAxis.add(node);
                    break;
                }
            }
        }
        timeAxis.sort(Comparator.comparing(o -> o.get(0)));
        return true;
    }
}

class Calendar {
    public int begin;
    public int end;
    public Calendar Substitute;
}
