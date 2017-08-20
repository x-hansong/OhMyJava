package com.leecode.easy;

import com.leecode.datastructure.TreeNode;

/**
 * Created by xhans on 2016/2/4.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }else {
            TreeNode temp = invertTree(root.right);
            root.right = invertTree(root.left);
            root.left = temp;
            return root;
        }
    }

}
