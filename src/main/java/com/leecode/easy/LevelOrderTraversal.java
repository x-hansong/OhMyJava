package com.leecode.easy;

import com.leecode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhans on 2016/2/15.
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        preTraversal(levels, root, 0);
        return levels;
    }

    private void preTraversal(List<List<Integer>> levels, TreeNode root, int n){
        if (root == null){
            return;
        } else {
            if (levels.size() == n){
                levels.add(new ArrayList<Integer>());
            }
            levels.get(n).add(root.val);
            preTraversal(levels, root.left, n+1);
            preTraversal(levels, root.right, n+1);
        }
    }
}
