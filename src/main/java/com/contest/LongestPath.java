package com.contest;

/**
 * Created by xhans on 2016/4/19.
 */
public class LongestPath {
    public static class TreeNode {
        int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int maxLen;

    public int findPath(TreeNode root) {
        // write code here
        maxLen = 0;
        longestPath(root, root, 1);
        return maxLen;
    }

    public void longestPath(TreeNode cur, TreeNode pre, int height){
        if (cur == null){
            maxLen = Math.max(maxLen, height);
            return;
        }
        if (cur.val != pre.val){
            maxLen = Math.max(maxLen, height);
            longestPath(cur.left, cur, 1);
            longestPath(cur.right, cur, 1);
        } else {
            longestPath(cur.left, cur, height + 1);
            longestPath(cur.right, cur, height + 1);
        }
    }
}
