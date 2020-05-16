package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/28
 */
public class Ms56 {

    public static void main(String[] args) {


        new Ms56().singleNumbers(new int[]{1, 1, 4, 3, 2, 2,});
    }

    public int[] singleNumbers(int[] nums) {
        int n = 0;
        //找到目标值 a,b 异或值 n= a^b;
        for (int i : nums) {
            n ^= i;
        }
        //找到最低不同位 因为a!=b所有他们有位值不相同
        int target = 1;
        while ((target & n) == 0) {
            target = target << 1;
        }

        int a = 0;
        int b = 0;
        for (int i : nums) {
            //通过最低不同将数据分组 a和b一定分到不同组 获取
            if ((target & i) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }

        }
        return new int[]{a, b};
    }

}
