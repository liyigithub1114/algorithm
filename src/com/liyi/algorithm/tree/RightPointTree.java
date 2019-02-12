package com.liyi.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将下面的树
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * 转换成
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class RightPointTree {
    public static void main(String[] args) {
        PointTree pointTree = new PointTree(1);
        pointTree.left = new PointTree(2);
        pointTree.right = new PointTree(3);
        pointTree.left.left = new PointTree(4);
        pointTree.left.right = new PointTree(5);
        pointTree.right.right = new PointTree(7);
        getPointTree(pointTree);
    }

    public static PointTree getPointTree(PointTree tree){
        if(tree == null) return tree;
        Queue<PointTree> queue = new LinkedList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            int high = queue.size();
            for(int i =0;i<high;i++){
                PointTree poll = queue.poll();
                if(i == high -1){
                    poll.next = null;
                }else{
                    poll.next = queue.peek();
                }

                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
        }
        return tree;
    }

    /**
     * 进阶，不使用额外空间，使用递归方法解决
     */

    public static void connect(PointTree root){
        PointTree dummyhead = new PointTree(0);
        PointTree current = null;
        while (root != null) {
            current = dummyhead;
            while (root != null) {
                if (root.left != null) { current.next = root.left; current = current.next; }
                if (root.right != null) { current.next = root.right; current = current.next; }
                root = root.next;
            }
            root = dummyhead.next;
            dummyhead.next = null;
        }
    }
}

