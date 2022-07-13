package com.leaf.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author tongshujian
 * @date 2022/7/13
 */
public class Lc735 {

    public static void main(String[] args) {
        int[] array = new Lc735().asteroidCollision(new int[]{10, 2, -5});
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int planet : asteroids) {
            //向左走
            if (planet < 0) {
                if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.add(planet);
                } else {
                    boolean blast = false;
                    while (!stack.isEmpty() && stack.peekLast() > 0) {
                        //如果栈顶数据大于当前行星 当前行星爆了
                        if (Math.abs(stack.peekLast()) > Math.abs(planet)) {
                            blast = true;
                            break;
                        } else if (Math.abs(stack.peekLast()) == Math.abs(planet)) {
                            //同归于尽
                            stack.pollLast();
                            blast = true;
                            break;
                        } else {
                            //消灭栈顶行星
                            stack.pollLast();
                        }
                    }
                    if (!blast) {
                        stack.add(planet);
                    }
                }
            } else {
                stack.add(planet);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.poll();
        }
        return result;
    }
}
