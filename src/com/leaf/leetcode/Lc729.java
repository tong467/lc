package com.leaf.leetcode;

import java.util.*;

/**
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数x 的范围为， start <= x < end 。
 * 实现 MyCalendar 类：
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false并且不要将该日程安排添加到日历中。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/my-calendar-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc729 {
}

/**
 * 使用map存储日程安排，key使用“，”将起止时间拼接，
 * 判断新数据是否与原有数据有相交，采用3个条件判断，
 *  1.开始时间在范围内;
 *  2.截止时间在范围内;
 *  3.新的时间范围完全包围旧时间范围;
 */
class MyCalendar {

    Map<String, List<Integer>> map;


    public MyCalendar() {
        map = new HashMap<>();
    }

    public boolean book(int start, int end) {
        String key = start + "," + end;
        if (map.containsKey(key)) {
            return false;
        }
        for (String tempKey : map.keySet()) {
            String[] keyArray = tempKey.split(",");
            int keyStart = Integer.parseInt(keyArray[0]);
            int keyEnd = Integer.parseInt(keyArray[1]);
            if ((keyStart <= start && start < keyEnd) || (keyStart < end && end < keyEnd)
                    || (start <= keyStart && end >= keyEnd)) {
                return false;
            }
        }
        List list = new ArrayList();
        Collections.addAll(list, start, end);
        map.put(key, list);
        return true;
    }
}