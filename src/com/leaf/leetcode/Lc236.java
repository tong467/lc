package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2020/5/10
 */
public class Lc236 {

    public static void main(String[] args) {
//        [3,5,1,6,2,0,8,null,null,7,4]

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(4);

        System.out.println(new Lc236().lowestCommonAncestor(root, root.left, root.right.right.right).val);
    }

    private Map<TreeNode, TreeNode> bfs(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ceng = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        ceng.add(root);
        int j = 0;
        while (!ceng.isEmpty()) {
            List<TreeNode> tempCeng = new ArrayList<>();
            for (int i = 0; i < ceng.size(); i++) {
                TreeNode tn = ceng.get(i);
                if (tn == p || tn == q) {
                    j++;
                }
                if (tn.left != null) {
                    parent.put(tn.left, tn);
                    tempCeng.add(tn.left);
                }
                if (tn.right != null) {
                    parent.put(tn.right, tn);
                    tempCeng.add(tn.right);
                }
                if (j == 2) {
                    break;
                }
            }
            ceng = tempCeng;
        }
        return parent;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> parent = bfs(root, p, q);

        Set<TreeNode> qSet = new HashSet<>();
        while (q != null) {
            qSet.add(q);
            q = parent.get(q);
        }
        while (p != null) {
            if (qSet.contains(p)) {
                return p;
            } else {
                p = parent.get(p);
            }
        }
        return null;
    }
}
