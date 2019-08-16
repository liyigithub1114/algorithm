package com.liyi.algorithm.tree;

//[2,5,6,0,,7,1]

import java.util.Stack;

/**
 *      6
 *   5     3
 * 2  #   0  1
 */
public class MaxTree {
    public static void main(String[] args) {

        PrintTree.printTree(maxTree(new int[]{2, 5, 6, 0, 7, 1}));
    }

    public static Tree maxTree(int[] A){
        if(A == null || A.length == 0){
            return null;
        }
        //这题和直方图类似，用栈维护一个降维的数组
        Stack<Tree> stack = new Stack<>();

        for(int i = 0; i < A.length; i++){
            Tree temp = new Tree(A[i]);

            while(!stack.isEmpty() && A[i] > stack.peek().value){
                Tree pop = stack.pop();
                temp.left  = pop;
            }

            if(!stack.isEmpty()){
                stack.peek().right = temp;
            }
            stack.push(temp);
        }

        Tree root = null;
        while(!stack.isEmpty()){
            root = stack.pop();
        }

        return root;
    }
}
