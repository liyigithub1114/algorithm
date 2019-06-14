package com.liyi.algorithm.tree;



public class BSTIterator {

    /*private Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(Tree root) {
        addTreeToQueue(root);
    }

    *//** @return the next smallest number *//*
    public int next() {
        if(!queue.isEmpty()){
            return queue.poll();
        }
        return -1;
    }

    *//** @return whether we have a next smallest number *//*
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void addTreeToQueue(Tree root){
        if(root != null){
            addTreeToQueue(root.left);
            this.queue.add(root.value);
            addTreeToQueue(root.right);
        }
    }*/

}
