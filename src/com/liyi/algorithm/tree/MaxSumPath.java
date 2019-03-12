package com.liyi.algorithm.tree;

/**
 * 求树的最大路径和
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
public class MaxSumPath {
    int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
    }

    public int getMax(Tree root){
        getMax2(root);
        return res;
    }

    public int getMax2(Tree root){
        if(root == null) return 0;
        int left = Math.max(getMax2(root.left),0);
        int right = Math.max(getMax2(root.right),0);

        res = Math.max(res,root.value + left + right);
        return Math.max(left,right) + root.value;
    }
}
