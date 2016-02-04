package com.easy;

/**
 * Created by xhans on 2016/2/4.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
