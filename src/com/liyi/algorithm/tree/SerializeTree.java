package com.liyi.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {

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

        PrintTree.printTree(head);
        String serial = serial(head);
        System.out.println(serial);
        Tree tree = backTree(serial);
        PrintTree.printTree(tree);
    }

    public static String serial(Tree head){
        if (head == null) return "#!";
        String res= "";
        res += head.value +"!";
        res +=serial(head.left);
        res += serial(head.right);
        return res;
    }

    public static Tree backTree(String string){
        if(string == null) return null;
        Queue<String> queue = new LinkedList<>();
        String[] split = string.split("!");
        for(int i =0;i<split.length;i++){
            queue.add(split[i]);
        }
        return parseQueue(queue);
    }

    private static Tree parseQueue(Queue<String> queue) {
        if(queue.isEmpty()) return null;
        String poll = queue.poll();
        if("#".equals(poll)) return null;
        Tree tree = new Tree(Integer.parseInt(poll));
        tree.left = parseQueue(queue);
        tree.right = parseQueue(queue);
        return tree;
    }
}
