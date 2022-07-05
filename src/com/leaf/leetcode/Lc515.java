package com.leaf.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author tongshujian
 * @date 2022/6/24
 */
public class Lc515 {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);

//        System.out.println(new Lc515().largestValues(treeNode));
        System.out.println(new Lc515().largestValues(null));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                Integer max = Integer.MIN_VALUE;

                while (size > 0) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    size--;
                    max = Math.max(max, treeNode.val);
                }
                result.add(max);
            }
        }
        return result;
    }


    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            List<TreeNode> layer = new ArrayList<>();
            layer.add(root);

            while (layer.size() != 0) {
                Integer max = Integer.MIN_VALUE;
                List<TreeNode> nextLayer = new ArrayList<>();

                for (TreeNode treeNode : layer) {
                    if (treeNode.right != null) {
                        nextLayer.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        nextLayer.add(treeNode.left);
                    }
                    max = Math.max(max, treeNode.val);
                }
                result.add(max);
                layer = nextLayer;
            }
        }
        return result;
    }

}
