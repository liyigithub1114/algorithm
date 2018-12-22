package com.liyi.algorithm.tree;


public class IsBalanceTree {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.left.left = new Tree(5);
        System.out.println(isB(tree).isB);
    }

    public static ReturnData isB(Tree head){
        if(head == null) return new ReturnData(true,0);

        ReturnData left = isB(head.left);
        if(!left.isB){
            return new ReturnData(false,0);
        }
        ReturnData right = isB(head.right);
        if(!right.isB){
            return new ReturnData(false,0);
        }

        if(Math.abs(left.h-right.h) > 1){
            return new ReturnData(false,0);
        }

        return new ReturnData(true,Math.max(left.h,right.h) +1);
    }

}
class ReturnData{
    boolean isB;
    int h;
    public ReturnData(boolean isB,int h){
        this.isB = isB;
        this.h = h;
    }
}
