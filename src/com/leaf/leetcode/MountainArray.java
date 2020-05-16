package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/29
 */
public class MountainArray {

    int[] array;

    public MountainArray(int[] array) {
        this.array = array;
    }

    public int get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }

}
