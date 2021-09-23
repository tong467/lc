package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongshujian
 * @date 2020/6/16
 */
public class Lc297 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Lc297().serialize(root));

//        System.out.println(new Lc297().serialize(new Lc297().deserialize("1,2,3,null,null,4,5")));
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        boolean isOk = false;
        while (!isOk) {
            isOk = true;
            List<TreeNode> tempList = new ArrayList<>();
            for (TreeNode node : list) {
                if (node != null) {
                    tempList.add(node.left);
                    tempList.add(node.right);
                    if (node.left != null || node.right != null) {
                        isOk = false;
                    }
                }
                if (node != null) {
                    sb.append(node.val);
                } else {
                    sb.append("null");
                }
                sb.append(",");
            }
            list = tempList;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        if (array.length == 0 || array[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int i = 1;
        boolean isOk = false;
        while (!isOk) {
            isOk = true;
            List<TreeNode> tempList = new ArrayList<>();
            for (TreeNode node : list) {
                if (i == array.length) {
                    break;
                }
                if (node != null) {
                    if (!array[i].equals("null")) {
                        node.left = new TreeNode(Integer.parseInt(array[i]));
                        tempList.add(node.left);
                        isOk = false;
                    } else {
                        tempList.add(null);
                    }
                    i++;
                    if (!array[i].equals("null")) {
                        node.right = new TreeNode(Integer.parseInt(array[i]));
                        tempList.add(node.right);
                        isOk = false;
                    } else {
                        tempList.add(null);
                    }
                    i++;
                }
            }
            list = tempList;
        }
        return root;
    }


}
