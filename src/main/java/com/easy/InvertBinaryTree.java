package com.easy;

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


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
