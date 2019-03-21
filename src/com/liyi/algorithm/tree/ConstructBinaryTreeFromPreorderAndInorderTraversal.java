package com.liyi.algorithm.tree;

/**
 * 根据先序遍历和中序遍历返回一棵二叉树
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private static int index = 0;
    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{1,3,2};
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
    public static Tree buildTree(int[] preorder, int[] inorder,int next,int inStart,int inEnd) {
        if(index == preorder.length || inStart == inorder.length  || inEnd < 0) return null;
        int val = preorder[next];
        Tree tree = new Tree(val);
        if(inStart == inEnd){
            return tree;
        }
        for(int i =inStart;i<= inEnd;i++){
            if(inorder[i] == val){
                if(i -1 >= inStart){
                    tree.left = buildTree(preorder,inorder,++index,inStart,i - 1);
                }
                if(inEnd >= i+1){
                    tree.right = buildTree(preorder,inorder,++index,i+1,inEnd);
                }
            }
        }
        return tree;
    }
}
