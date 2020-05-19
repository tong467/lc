package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author tongshujian
 * @date 2020/5/17
 */
//TODO 没有自己解决
public class Lc210 {

    public static void main(String[] args) {
//        new Lc210().findOrder1(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }


//    public int[] findOrder1(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> parentMap = new HashMap<>();
//        Map<Integer, Integer> preMap = new HashMap<>();
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            int a0 = prerequisites[i][0];
//            int a1 = prerequisites[i][1];
//            //有前置课程
//            if (parentMap.containsKey(a0)) {
//                parentMap.get(a0).add(a1);
//                int pre = Integer.MAX_VALUE;
//
//                for (Integer parentPre : parentMap.get(a0)) {
//                    pre = Math.min(pre, preMap.get(parentPre) + 1);
//                }
//
//                preMap.put(a0, pre);
//
//            } else {
//                List<Integer> tempList = new ArrayList<>();
//                tempList.add(a1);
//                parentMap.put(a0, tempList);
//                preMap.put(a0, preMap.getOrDefault(a1, 0) + 1);
//                //如果前置课程不存在前置课程将前置课程改为0;
//                if (!preMap.containsKey(a1)) {
//                    preMap.put(a1, 0);
//                }
//            }
//        }
//
//        while (true) {
//            //找到 preMap 值为0的节点
//            for (Entry<Integer, Integer> par : preMap.entrySet()) {
//                if(par.getValue()==0){
//                    numCourses --;
//                }
//            }
//
//
//        }
//
//        return new int[0];
//
//    }
//
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < prerequisites.length; i++) {
//            int a0 = prerequisites[i][0];
//            int a1 = prerequisites[i][1];
//            if (result.isEmpty()) {
//                List<Integer> tempList = new ArrayList<>();
//                tempList.add(a1);
//                tempList.add(a0);
//                result.add(tempList);
//            } else {
//                boolean isNew = true;
//                for (List<Integer> tempList : result) {
//                    for (int k = tempList.size() - 1; k >= 0; k++) {
//                        if (tempList.get(k) == a1) {
//                            tempList.add(k + 1, a0);
//                            isNew = false;
//                        }
//                        break;
//                    }
//                }
//                //如果这个节点没有加入任何已知节点需要创建新链表
//                if (isNew) {
//                    List<Integer> tempList = new ArrayList<>();
//                    tempList.add(a1);
//                    tempList.add(a0);
//                    result.add(tempList);
//                }
//            }
//
//            for (List<Integer> tempList : result) {
//                if (tempList.size() == numCourses) {
//                    //输出结果
//                    int[] rArray = new int[numCourses];
//                    for (int k = 0; k < rArray.length; k++) {
//                        rArray[k] = tempList.get(k);
//                    }
//                    return rArray;
//                }
//            }
//        }
//        return new int[0];
//    }
}
