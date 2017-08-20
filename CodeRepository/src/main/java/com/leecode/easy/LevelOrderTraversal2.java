package com.leecode.easy;

import com.leecode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xhans on 2016/2/14.
 */
public class LevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<List<Integer>>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            Queue<TreeNode> buffer = new LinkedList<TreeNode>();

            queue.add(root);
            while (!queue.isEmpty()) {
                LinkedList<Integer> level = new LinkedList<Integer>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.remove();
                    level.add(node.val);

                    if (node.left != null) {
                        buffer.add(node.left);
                    }
                    if (node.right != null) {
                        buffer.add(node.right);
                    }
                }
                levels.addFirst(level);
                while (!buffer.isEmpty()) {
                    queue.add(buffer.remove());
                }
            }
        }
        return levels;
    }
}
