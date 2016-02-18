package com.easy;

import com.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhans on 2016/2/18.
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<String>();

        dfs(root, paths, "");

        return paths;
    }

    private void dfs(TreeNode root, List<String> paths, String path){
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            paths.add(path + root.val);
            return;
        }
        dfs(root.left, paths, path + root.val + "->" );
        dfs(root.right, paths, path + root.val + "->");
    }
}
