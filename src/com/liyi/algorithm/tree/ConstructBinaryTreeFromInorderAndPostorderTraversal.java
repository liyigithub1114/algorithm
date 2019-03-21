package com.liyi.algorithm.tree;

/**
 * 中序后序 生成树
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private static int index = 0;

    public static Tree buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        index = postorder.length - 1;
        return buildTree(inorder,postorder,index,0,postorder.length - 1);
    }

    public static Tree buildTree(int[] inorder,int[] postorder,int next,int inStart,int inEnd){
        if(next == -1 || inStart == inorder.length || inEnd < 0) return null;
        int val = postorder[next];
        Tree tree = new Tree(val);
        if(inStart == inEnd){
            return tree;
        }
        for(int i =inStart;i<= inEnd;i++){
            if(inorder[i] == val){
                if(i+1 <= inEnd){
                    tree.right = buildTree(inorder,postorder,--index,i+1,inEnd);
                }
                if(inStart <= i-1){
                    tree.left = buildTree(inorder,postorder,--index,inStart,i-1);
                }
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        Tree tree = buildTree(inorder, postorder);
        System.out.println(tree);
    }
}
