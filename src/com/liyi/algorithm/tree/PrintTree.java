package com.liyi.algorithm.tree;

public class PrintTree {

    public static void printTree(Tree head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Tree head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Tree head = new Tree(1);
        head.left = new Tree(-222222222);
        head.right = new Tree(3);
        head.left.left = new Tree(Integer.MIN_VALUE);
        head.right.left = new Tree(55555555);
        head.right.right = new Tree(66);
        head.left.left.right = new Tree(777);
        printTree(head);

        head = new Tree(1);
        head.left = new Tree(2);
        head.right = new Tree(3);
        head.left.left = new Tree(4);
        head.right.left = new Tree(5);
        head.right.right = new Tree(6);
        head.left.left.right = new Tree(7);
        printTree(head);

        head = new Tree(1);
        head.left = new Tree(1);
        head.right = new Tree(1);
        head.left.left = new Tree(1);
        head.right.left = new Tree(1);
        head.right.right = new Tree(1);
        head.left.left.right = new Tree(1);
        printTree(head);
    }
}
