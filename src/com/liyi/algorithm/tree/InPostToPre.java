package com.liyi.algorithm.tree;

public class InPostToPre {
    public static void main(String[] args) {

    }
    public Tree buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        //inorder = 左 中 右
        //postOrder = 左 右 中

        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    public Tree helper(int[] inorder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd){
            return null;
        }

        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == postOrder[postEnd]){
                rootIndex = i;
                break;
            }
        }

        Tree root = new Tree(inorder[rootIndex]);

        root.left = helper(inorder, postOrder, inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);

        root.right = helper(inorder, postOrder, rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd -1);

        return root;
    }
}
