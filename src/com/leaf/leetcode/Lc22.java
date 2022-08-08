package com.leaf.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author tongshujian
 * @date 2022/7/18
 */
public class Lc22 {

    public static void main(String[] args) {
        new Lc22().generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        TreeNode treeNode = new TreeNode();
        treeNode.str = "(";

        buildTree(treeNode, n);

        List<TreeNode> list = new ArrayList<>();
        list.add(treeNode);
        List<TreeNode> nextList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).left != null) {
                nextList.add(list.get(i).left);
            }
            if (list.get(i).right != null) {
                nextList.add(list.get(i).right);
            }
            if (i == list.size() - 1 && !nextList.isEmpty()) {
                list = nextList;
                nextList = new ArrayList<>();
                i = -1;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (TreeNode treeNode1 : list) {
            StringBuilder sb = new StringBuilder();
            while (treeNode1 != null) {
                sb.append(treeNode1.str);
                treeNode1 = treeNode1.parent;
            }
            stringList.add(sb.reverse().toString());
        }

        return stringList;
    }

    public void buildTree(TreeNode treeNode, int n) {
        int leafCount = 0;
        int rightCount = 0;
        TreeNode tempNode = treeNode;
        while (tempNode != null) {
            if (tempNode.str.equals("(")) {
                leafCount++;
            }
            if (tempNode.str.equals(")")) {
                rightCount++;
            }
            tempNode = tempNode.parent;
        }
        if ((rightCount == n && leafCount < n) || rightCount > leafCount) {
            return;
        }
        if (leafCount < n) {
            treeNode.left = new TreeNode();
            treeNode.left.str = "(";
            treeNode.left.parent = treeNode;
            buildTree(treeNode.left, n);
        }
        if (rightCount < n) {
            treeNode.right = new TreeNode();
            treeNode.right.str = ")";
            treeNode.right.parent = treeNode;
            buildTree(treeNode.right, n);
        }

    }

    class TreeNode {

        private String str;
        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;
    }


}
