package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongshujian
 * @date 2020/4/22
 */
public class Lc199 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        List<Integer> a =new Lc199().rightSideView(root);
        System.out.println(a.size());
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> currentLayer = new ArrayList<>();
        if (root == null) {
            return result;
        }
        currentLayer.add(root);
        while (!currentLayer.isEmpty()) {
            result.add(currentLayer.get(currentLayer.size() - 1).val);
            List<TreeNode> nextLayer = new ArrayList<>();
            for (TreeNode treeNode : currentLayer) {
                if (treeNode.left != null) {
                    nextLayer.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLayer.add(treeNode.right);
                }
            }
            currentLayer = nextLayer;
        }
        return result;
    }
}
