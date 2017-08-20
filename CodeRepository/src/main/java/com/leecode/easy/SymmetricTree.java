package com.leecode.easy;

import com.leecode.datastructure.TreeNode;

/**
 * Created by xhans on 2016/2/14.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirrorTree(root.left, root.right);
    }

    private boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return  p.val == q.val && isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
    }
}
