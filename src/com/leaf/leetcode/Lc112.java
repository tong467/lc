package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2019/12/2
 */
public class Lc112 {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.right.left = new TreeNode(13);
//        root.right.left.right = new TreeNode(1);
//        root.right.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);

        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        System.out.println(new Lc112().hasPathSum(root, -5));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        List<TreeNode> list = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        boolean isEnd = false;
        list.add(root);
        map.put(root, root.val);
        while ((!list.isEmpty()) && (!isEnd)) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode : list) {
                Integer i = map.get(treeNode);
                if (treeNode.left == null && treeNode.right == null && i == sum) {
                    return true;
                }
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                    map.put(treeNode.left, i + treeNode.left.val);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                    map.put(treeNode.right, i + treeNode.right.val);
                }
            }
            list = temp;
        }
        return false;
    }
}