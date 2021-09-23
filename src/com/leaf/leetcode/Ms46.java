package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tongshujian
 * @date 2020/6/9
 */
public class Ms46 {

    public static void main(String[] args) {
        System.out.println(new Ms46().translateNum(12258));
    }

    public int translateNum(int num) {
        int i = 0;
        TreeNode root = new TreeNode(0);
        treeNode(root, num);
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        while (!rootList.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : rootList) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
                if (node.left == null && node.right == null) {
                    i++;
                }
            }
            rootList = temp;
        }
        return i;
    }


    public void treeNode(TreeNode root, int num) {
        if (num == 0) {
            return;
        }

        if (10 <= num % 100 && num % 100 <= 25) {
            //2个子节点
            root.left = new TreeNode(num % 10);
            treeNode(root.left, num / 10);
            root.right = new TreeNode(num % 100);
            treeNode(root.right, num / 100);
        } else {
            root.left = new TreeNode(num % 10);
            treeNode(root.left, num / 10);
        }
    }
}
