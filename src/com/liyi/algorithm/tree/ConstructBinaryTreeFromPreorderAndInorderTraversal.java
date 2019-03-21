package com.liyi.algorithm.tree;

/**
 * 根据先序遍历和中序遍历返回一棵二叉树
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,11,12,20,15,7};
        int[] inorder = new int[]{11,9,12,3,15,20,7};
        Tree tree = buildTree(preorder,inorder,0,0,inorder.length-1);
        System.out.println(tree);
    }
    //先序bac  中序abc
    //preorder = [3,9,11,12,20,15,7]
    //inorder = [11,9,12,3,15,20,7]

    /**
     *  首先pre 里面拿到根 3
     *  3的index = 3  0-2 是 3的左边  4-6 是3的右边
     *
     *  对于 11，9，12
     */
    public static Tree buildTree(int[] preorder, int[] inorder,int index,int inStart,int inEnd) {
        if(index == preorder.length || inStart == inorder.length  || inEnd < 0 ) return null;
        int val = preorder[index];
        Tree tree = new Tree(val);
        for(int i =0;i<inorder.length;i++){
            if(inorder[i] == val){
                tree.left = buildTree(preorder,inorder,index+1,inStart,i - 1);
                tree.right = buildTree(preorder,inorder,index+1,i+1,inEnd);
            }
        }
        return tree;
    }
}
