package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/21
 */
public class Lc1248 {

    public static void main(String[] args) {
        System.out.println(new Lc1248().numberOfSubarrays1(
                new int[]{2, 4, 6}, 100));
    }

    public int numberOfSubarrays1(int[] nums, int k) {
        int result = 0;
        int head = 0;
        int last = 0;
        int numbers = 0;
        //找到第一个范围区间;
        label1:
        for (int i = 0; i < nums.length; i++) {
            numbers=0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 != 0) {
                    numbers++;
                }
                if (numbers == k) {
                    result++;
                    last = j;
                    for (int l = j + 1; l < nums.length; l++) {
                        if (nums[l] % 2 == 0) {
                            result++;
                        } else {
                            break;
                        }
                    }
                    break label1;
                }
            }
        }

        if (result != 0) {

            while (last < nums.length) {
                //移动头节点
                while (head < nums.length) {
                    //头结点偶数
                    if (nums[head] % 2 == 0) {
                        head = head + 1;
                        result++;
                        for (int l = last + 1; l < nums.length; l++) {
                            if (nums[l] % 2 == 0) {
                                result++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        head = head + 1;
                        for (last++; last < nums.length; last++) {
                            if (nums[last] % 2 != 0) {
                                result++;
                                for (int l = last + 1; l < nums.length; l++) {
                                    if (nums[l] % 2 == 0) {
                                        result++;
                                    } else {
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (last == nums.length) {
                            return result;
                        }
                    }
                }
            }

            //偶数-偶数  尾结点 循环下一个奇数 做合

            //偶数 - 奇数 尾结点 循环下一个奇数 做合

            //奇数-到xxx  少一个偶数 尾节点移动至 下一个奇数

        }
        return result;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        label1:
        for (int i = 0; i < nums.length; i++) {
            int numbers = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 != 0) {
                    numbers++;
                }
                if (numbers == k) {
                    result++;
                    for (int l = j + 1; l < nums.length; l++) {
                        if (nums[l] % 2 == 0) {
                            result++;
                        } else {
                            break;
                        }
                    }

                    continue label1;
                }
            }
        }
        return result;
    }
}
