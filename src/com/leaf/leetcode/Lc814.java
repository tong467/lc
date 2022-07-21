package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc814 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        new Lc814().pruneTree(root);
    }


    public TreeNode pruneTree(TreeNode root) {
        if (!isExist1(root)) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        while (!list.isEmpty()) {
            List<TreeNode> nextList = new ArrayList<>();
            for (TreeNode treeNode : list) {
                if (treeNode.left != null) {
                    if (!isExist1(treeNode.left)) {
                        treeNode.left = null;
                    } else {
                        nextList.add(treeNode.left);
                    }
                }
                if (treeNode.right != null) {
                    if (!isExist1(treeNode.right)) {
                        treeNode.right = null;
                    } else {
                        nextList.add(treeNode.right);
                    }
                }
            }
            list = nextList;
        }
        return root;
    }

    public boolean isExist1(TreeNode root) {
        if (root.val == 1) {
            return true;
        }
        boolean returnFlag = false;
        if (root.left != null) {
            if (isExist1(root.left)) {
                return true;
            }
        }
        if (root.right != null) {
            if (isExist1(root.right)) {
                return true;
            }
        }
        return false;
    }
}
