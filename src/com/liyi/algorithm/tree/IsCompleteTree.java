package com.liyi.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public static void main(String[] args) {

    }

    public static boolean isComplete(Tree head){
        if(head == null) return true;
        Queue<Tree> queue = new LinkedList<>();
        boolean flag = false;//如果右子树为空，则以后的每一个节点都没有子节点
        queue.add(head);
        while(!queue.isEmpty()){
            Tree tree = queue.poll();
            if((tree.left == null && tree.right != null) || (flag && (tree.left != null || tree.right != null))){
                return false;
            }
            if(tree.left != null){
                queue.add(tree.left);
            }
            if(tree.right != null){
                queue.add(tree.right);
            }else {
                flag =  true;
            }
        }
        return true;
    }
}

/*
     O
   O   O
  0 0
 */