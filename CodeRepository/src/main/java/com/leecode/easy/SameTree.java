package com.leecode.easy;

import com.leecode.datastructure.TreeNode;

/**
 * Created by xhans on 2016/2/7.
 */
public class SameTree {


    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        } else if (p != null && q != null){
            if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)){
                return true;
            }
        }
        return false;
    }

    public boolean isSameTree1(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
