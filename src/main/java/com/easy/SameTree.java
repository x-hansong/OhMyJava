package com.easy;

import com.datastructure.TreeNode;

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
}
