package com.liyi.algorithm.tree;

/**
 * 求二叉树是否左右对称
 */
public class TreeSymmetric {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(Tree root) {
        if(root == null) return true;
        return compare(root.left,root.right);
    }

    public boolean compare(Tree left,Tree right){
        if(left == null && right == null) return true;
        if(left != null && right == null) return false;
        if(left == null && right != null) return false;
        return (left.value == right.value) && compare(left.left,right.right) && compare(left.right,right.left);
    }
}
