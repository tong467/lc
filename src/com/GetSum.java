package com;

/**
 * 371. 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 */
public class GetSum {

    public static void main(String[] args) {
        System.out.println(new GetSum().getSum(8, 8));
    }


    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            System.out.print(carry);
            a = a ^ b;
            System.out.print(" "+a);
            b = carry;
            System.out.println();
        }
        return a;
    }
}
