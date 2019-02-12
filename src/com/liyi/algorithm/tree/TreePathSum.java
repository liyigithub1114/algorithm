package com.liyi.algorithm.tree;

/**
 * 求二叉树从头节点到根节点是否含有 累加和为sum的路径
 */
public class TreePathSum {
    public static void main(String[] args) {

    }
    public boolean hasPathSum(Tree root, int sum) {
        if(root == null) return false;
        if(root.value - sum == 0 && root.left == null && root .right == null) return true;
        return hasPathSum(root.left,sum-root.value) || hasPathSum(root.right,sum-root.value);
    }
}
