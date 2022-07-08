package com.leaf.leetcode;

/**
 * 有n个筹码。第 i 个筹码的位置是position[i]。
 * <p>
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从position[i]改变为:
 * <p>
 * position[i] + 2或position[i] - 2，此时cost = 0
 * position[i] + 1或position[i] - 1，此时cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc1217 {
    /**
     * 该题目说移动2部不需要成本，那意味着所有的数据都一个移动到0，1上，其实就是转化为所有求所有数据奇数和偶数的数量取数量小的值
     *
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int j = 0, o = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                o++;
            } else {
                j++;
            }
        }
        return Math.min(j, o);
    }
}
