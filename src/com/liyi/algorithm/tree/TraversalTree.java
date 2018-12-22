package com.liyi.algorithm.tree;

import java.util.Stack;

public class TraversalTree {

    public static void main(String[] args) {
        Tree head = new Tree(5);
        head.left = new Tree(3);
        head.right = new Tree(8);
        head.left.left = new Tree(2);
        head.left.right = new Tree(4);
        head.left.left.left = new Tree(1);
        head.right.left = new Tree(7);
        head.right.left.left = new Tree(6);
        head.right.right = new Tree(10);
        head.right.right.left = new Tree(9);
        head.right.right.right = new Tree(11);

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        posOrder(head);
        System.out.println();

        System.out.println("--------------");

        preOrderNoRecursion(head);
        System.out.println();
        inOrderNoRecursion(head);
        System.out.println();
        posOrderNoRecursion(head);
    }

    public static void preOrder(Tree head){
        if (head == null) return ;
        System.out.print(head.value+" ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void inOrder(Tree head){
        if(head == null) return ;
        inOrder(head.left);
        System.out.print(head.value+" ");
        inOrder(head.right);
    }

    public static void posOrder(Tree head){
        if(head == null) return ;
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.value+" ");
    }

    public static void preOrderNoRecursion(Tree head){
        if(head == null) return ;
        Stack<Tree> stack = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            Tree tree = stack.pop();
            System.out.print(tree.value+" ");
            if(tree.right!=null){
                stack.add(tree.right);
            }
            if(tree.left!=null){
                stack.add(tree.left);
            }
        }
    }

    public static void inOrderNoRecursion(Tree head){
        if(head == null) return ;
        Stack<Tree> stack = new Stack<>();
        //记住先左，再中，所以一开始不能添加中
        while(!stack.isEmpty() || head!=null){
            if(head != null){
                stack.add(head);
                head = head.left;
            }else {
                Tree tree = stack.pop();
                System.out.print(tree.value+" ");
                head = tree.right;
            }
        }
    }

    public static void posOrderNoRecursion(Tree head){
        if(head == null) return ;
        Stack<Tree> stack = new Stack<>();
        Stack<Integer> res = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            Tree tree = stack.pop();
            res.add(tree.value);
            if(tree.left!=null){
                stack.add(tree.left);
            }
            if(tree.right!=null){
                stack.add(tree.right);
            }
        }
        while(!res.isEmpty()){
            System.out.print(res.pop()+" ");
        }
    }
}
