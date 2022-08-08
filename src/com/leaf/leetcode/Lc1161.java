package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongshujian
 * @date 2022/8/1
 */
public class Lc1161 {

    public int maxLevelSum(TreeNode root) {

        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        int i = 1, layerTotal = root.val, layerMax = i;

        while (!layer.isEmpty()) {
            List<TreeNode> nextLayer = new ArrayList<>();
            int tempLayerTotal = 0;

            for (TreeNode treeNode : layer) {
                tempLayerTotal += treeNode.val;
                if (treeNode.left != null) {
                    nextLayer.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLayer.add(treeNode.right);
                }
            }
            layer = nextLayer;
            if (layerTotal < tempLayerTotal) {
                layerTotal = tempLayerTotal;
                layerMax = i;
            }
            i++;
        }

        return layerMax;
    }
}
