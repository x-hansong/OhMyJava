package com.leecode.easy;

import com.leecode.datastructure.TreeNode;

/**
 * Created by xhans on 2016/2/15.
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else if (root.left == null || root.right == null){
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
