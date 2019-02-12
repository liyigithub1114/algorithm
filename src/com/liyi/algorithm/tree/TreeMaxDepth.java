package com.liyi.algorithm.tree;

/**
 * 求二叉树的最大深度
 */
public class TreeMaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(Tree root) {
        if(root ==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
