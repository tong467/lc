package com.leaf.leetcode;

import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tongshujian
 * @date 2020/6/18
 */
public class Lc1028 {

    public static void main(String[] args) {
        TreeNode node = new Lc1028().recoverFromPreorder2("10-4-2--9---6----6-----9--5");
        TreeNode node2 = new Lc1028().recoverFromPreorder1("10-4-2--9---6----6-----9--5");
        System.out.println(node);
    }


    public TreeNode recoverFromPreorder2(String S) {
        Deque<TreeNode> path = new LinkedList<TreeNode>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }


    public TreeNode recoverFromPreorder1(String S) {
        int k = 0;
        for (; k < S.length(); k++) {
            if (S.charAt(k) == '-') {
                break;
            }
        }

        TreeNode root = new TreeNode(Integer.parseInt(S.substring(0, k)));
        TreeNode preNode = root;
        TreeNode preParnetNode = null;
        int preLayer = 0;
        int layer = 0;
        for (int i = k; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                layer++;
            } else {
                //获得之后数字
                int j = i + 1;
                for (; j < S.length(); j++) {
                    if (S.charAt(j) == '-') {
                        break;
                    }
                }
                int value = Integer.parseInt(S.substring(i, j));
                //获得该层节点又左向右插入
                if (layer > preLayer) {
                    preNode.left = new TreeNode(value);
                    preParnetNode = preNode;
                    preNode = preNode.left;
                } else if (layer == preLayer) {
                    preParnetNode.right = new TreeNode(value);
                    preNode = preParnetNode.right;
                } else {
                    //
                    //获得该层节点又左向右插入
                    List<TreeNode> treeNodeList = getByLayer(root, layer - 1);
                    for (TreeNode node : treeNodeList) {
                        if (node.left == null) {
                            continue;
                        }
                        if (node.right == null) {
                            node.right = new TreeNode(value);
                            preNode = node.right;
                            break;
                        }
                    }
                }
                i = j - 1;
                preLayer = layer;
                layer = 0;
            }
        }
        return root;
    }


    public TreeNode recoverFromPreorder(String S) {
        TreeNode root = new TreeNode(Integer.parseInt(S.substring(0, 1)));
        int layer = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                layer++;
            } else {

                //获得之后数字
                int j = i + 1;
                for (; j < S.length(); j++) {
                    if (S.charAt(j) == '-') {
                        break;
                    }
                }
                int value = Integer.parseInt(S.substring(i, j));
                //获得该层节点又左向右插入
                List<TreeNode> treeNodeList = getByLayer(root, layer - 1);
                for (TreeNode node : treeNodeList) {
                    if (node.left == null) {
                        node.left = new TreeNode(value);
                        break;
                    } else if (node.right == null) {
                        node.right = new TreeNode(value);
                        break;
                    }
                }
                i = j - 1;
                layer = 0;
            }
        }
        return root;
    }

    private List<TreeNode> getByLayer(TreeNode node, int layer) {
        List<TreeNode> list = new ArrayList<>();
        list.add(node);
        int i = 0;
        while (i < layer) {
            List<TreeNode> tempList = new ArrayList<>();
            for (TreeNode node1 : list) {
                if (node1.left != null) {
                    tempList.add(node1.left);
                }
                if (node1.right != null) {
                    tempList.add(node1.right);
                }
            }
            list = tempList;
            i++;
        }
        return list;
    }
}
