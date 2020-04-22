package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/19
 */
public class Lc466 {


    public static void main(String[] args) {
        System.out.println(new Lc466().getMaxRepetitions1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 1000000,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 103));
        System.out.println(new Lc466().getMaxRepetitions("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 1000000,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 103));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        int index2 = 0;
        // s2 循环了几次
        int loopTimesOnS2 = 0;

        for (int i = 0; i < n1; i++) {
            for (int index1 = 0; index1 < len1; index1++) {
                if (charArray1[index1] == charArray2[index2]) {
                    index2++;

                    // 如果 index2 遍历到末尾，循环计数器加 1，index2 重置到开头
                    if (index2 == len2) {
                        index2 = 0;
                        loopTimesOnS2++;
                    }
                }
            }
        }
        return loopTimesOnS2 / n2;
    }


    public int getMaxRepetitions1(String s1, int n1, String s2, int n2) {

        char[] cArray1 = s1.toCharArray();
        char[] cArray2 = s2.toCharArray();
        //循环次数
        int num = 0;
        int i = 0;
        int b = 0;
        int j = 0;
        for (int a = 0; a < n1; a++) {
            outer1:
            for (; i < cArray1.length; i++) {
                outer2:
                for (; b < n2;) {
                    for (; j < cArray2.length; ) {
                        //消灭一个字符j也移动
                        if (cArray1[i] == cArray2[j]) {
                            j++;
                            if (j == cArray2.length) {
                                j = 0;
                                b++;
                            }
                            if (b == n2) {
                                b = 0;
                                num++;
                            }
                        }
                        //移动i节点继续对比下一个字符
                        continue outer1;
                    }
                }

            }
            i = 0;
        }
        return num;
    }

//        public int getMaxRepetitions (String s1,int n1, String s2,int n2){
//
//            char[] cArray1 = s1.toCharArray();
//            char[] cArray2 = s2.toCharArray();
//            int a = 0;
//            int i = 0;
//            int j = 0;
//            int k = 0;
//
//            outer:
//            for (; a < n2; a++) {
//                outer1:
//                for (; i < cArray2.length; ) {
//                    for (; j < n1; j++) {
//                        for (; k < cArray1.length; k++) {
//                            if (cArray2[i] == cArray1[k]) {
//                                i++;
//                                k++;
//                                if (k == cArray1.length) {
//                                    j++;
//                                    k = 0;
//                                }
//                                //消灭一个字符
//                                continue outer1;
//                            } else {
//                                continue;
//                            }
//                        }
//                        k = 0;
//                    }
//                    //没有消灭完所有字符
//                    if (j == n1) {
//                        break outer;
//                    }
//                }
//                i = 0;
//            }
//            if (a == n2 && i == 0) {
//                if (j == 0) {
//                    return n1;
//                }
//                return n1 / j;
//            } else {
//                return 0;
//            }
//        }
//    }
}
