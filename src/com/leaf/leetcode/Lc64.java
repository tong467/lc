package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/6/2
 */
public class Lc64 {

    public static void main(String[] args) {

        System.out.println( (int) (Math.pow(3,2) + 3)>>1);

        System.out.println(new Lc64().sumNums(3));
    }


    public int sumNums(int n) {
        return sumNums(3, 0);
    }

    public int sumNums(int n, int res) {
        boolean x = n>1 && sumNums(n-1,res+n)>0;
        if (n > 0) {
             sumNums(n - 1, res + n);
        }
        return res;

    }


}
