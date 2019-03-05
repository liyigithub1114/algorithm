package com.liyi.algorithm.tree;

import java.util.*;

/**
 * 按照zigzag方式打印二叉树
 *input
 *     9
 *   12  20
 *  1  2  3  5
 *
 *output
 *  9
 *  20 12
 *  1 2 3 5
 *
 */
public class TraversalZigZag {
    public static void main(String[] args) {
        Tree head = new Tree(9);
        head.left = new Tree(12);
        head.right = new Tree(20);
//        head.left.left = new Tree(1);
//        head.left.right = new Tree(2);
        head.right.left = new Tree(3);
        head.right.right = new Tree(5);

        System.out.println(getZigZag(head));
    }

    public static List<List<Integer>> getZigZag(Tree head){
        if(head == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;

        Queue<Tree> queue = new LinkedList<>();
        Stack<Tree> stack = new Stack<>();
        queue.add(head);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(!flag){
                int h = queue.size();
                for(int i =0;i<h;i++){
                    Tree temp = queue.poll();
                    list.add(temp.value);
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                }
                flag = !flag;
            }else{
                int h = queue.size();
                for(int i =0;i<h;i++){
                    Tree temp = queue.poll();
                    stack.add(temp);
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                    if(temp.right!=null){
                        queue.add(temp.right);
                    }
                }
                while(!stack.isEmpty()){
                    list.add(stack.pop().value);
                }
                flag = !flag;
            }
            res.add(list);
        }
        return res;
    }
}
