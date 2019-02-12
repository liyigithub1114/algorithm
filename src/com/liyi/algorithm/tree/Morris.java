package com.liyi.algorithm.tree;

/**
 * morris 遍历，在不使用额外空间的情况下，遍历树
 *
 *使用递归或者使用栈对树进行遍历  一个节点会遍历3次
 * 使用morris遍历 如果当前节点有左子树，会遍历两次当前节点，如果没有，则会遍历一次
 */
public class Morris {


    /**
     *
     *              5
     *        3         8
     *     2    4    7    10
     *   1         6     9  11
     */
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
        //TraversalTree.preOrder(head);
        System.out.println();
        //morrisIn(head);
        morrisPre(head);
    }

    //中序遍历 ，
    public static void morrisIn(Tree head){
        if(head == null) return ;
        Tree cur = head;
        Tree mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value+" ");
            cur = cur.right;
        }
    }


    /**
     *
     *              5
     *        3         8
     *     2    4    7    10
     *   1         6     9  11
     */
    //5 3 2 1 4 8 7 6 10 9 11  先序遍历
    public static void morrisPre(Tree head){
        if(head == null) return ;
        Tree cur = head;
        Tree mostRight = null;
        while(cur != null ){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.value+" ");
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }else{
                System.out.print(cur.value+" ");
            }
            cur = cur.right;
        }
    }
}
