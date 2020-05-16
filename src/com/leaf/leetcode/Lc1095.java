package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/29
 */
public class Lc1095 {

    public static void main(String[] args) {
        System.out.println(new Lc1095().findInMountainArray(2, new MountainArray(new int[]{1,2,3,4,5,3,1})));
    }


    public int findInMountainArray(int target, MountainArray mountainArr) {

        int twist = findTwist(0, mountainArr.length() - 1, mountainArr);

        int index = findInMountainArray(0, twist, target, mountainArr, true);
        if (index == -1) {
            index = findInMountainArray(twist, mountainArr.length() - 1, target, mountainArr, false);
        }
        return index;

    }

    public int findTwist(int leaf, int right, MountainArray mountainArr) {
        if (leaf >= right) {
            return leaf;
        }
        int center = leaf + (right - leaf) / 2;
        //center 在上升区间
        if (mountainArr.get(center) < mountainArr.get(center + 1)) {
            return findTwist(center + 1, right, mountainArr);
        } else {
            return findTwist(leaf, center, mountainArr);
        }
    }


    public int findInMountainArray(int leaf, int right, int target, MountainArray mountainArr, boolean order) {
        if (leaf > right) {
            return -1;
        }

        int center = leaf + (right - leaf) / 2;
        if (mountainArr.get(center) == target) {
            return center;
        }
        boolean direction = order ? mountainArr.get(center) > target : mountainArr.get(center) < target;
        if (direction) {
            return findInMountainArray(leaf, center - 1, target, mountainArr, order);
        } else {
            return findInMountainArray(center + 1, right, target, mountainArr, order);
        }
    }

}
