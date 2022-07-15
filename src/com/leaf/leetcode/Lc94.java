package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        zongxu(root,a);
        return a;
    }

    private void zongxu(TreeNode root, List<Integer> a) {
        if (root != null) {
            zongxu(root.left, a);
            a.add(root.val);
            zongxu(root.right, a);
        }
    }
}
