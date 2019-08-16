package com.liyi.algorithm.tree;

public class PreInToPost {
    public static void main(String[] args) {

    }
    public Tree buildTree(int[] preorder,int[] inorder) {
        if(preorder == null || inorder == null){
            return null;
        }
        //inorder = 左 中 右
        //preorder = 中 左 右

        return helper(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);

    }

    public Tree helper(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd){
        if(inStart > inEnd){
            return null;
        }

        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == preorder[preStart]){
                rootIndex = i;
                break;
            }
        }

        Tree root = new Tree(inorder[rootIndex]);

        root.left = helper(inorder, preorder, inStart, rootIndex - 1, preStart + 1, preStart + rootIndex - inStart);

        root.right = helper(inorder, preorder, rootIndex + 1, inEnd,  preStart + rootIndex - inStart + 1, preEnd);
        return root;
    }
}
