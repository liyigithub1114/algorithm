package com.liyi.algorithm.tree;

public class IsSearchTree {

    public static void main(String[] args) {
        Tree tree = new Tree(5);
        tree.left = new Tree(4);
        tree.right = new Tree(6);
        tree.left.left = new Tree(7);

        System.out.println(isSearch(tree));
    }
    public static int preValue = Integer.MIN_VALUE;
    public static boolean isSearch(Tree head){
        if(head == null) return true;
        if(!isSearch(head.left)){
            return  false;
        }
        if(preValue > head.value){
            return false;
        }else {
            preValue = head.value;
        }
        if(!isSearch((head.right))){
            return false;
        }
        return true;
    }
}
