package com.liyi.algorithm.tree;

public class CompleteTreeNumber {
    public static void main(String[] args) {
        Tree head = new Tree(5);
        head.left = new Tree(3);
        head.right = new Tree(8);
        head.left.left = new Tree(2);
        head.left.right = new Tree(4);
        head.right.left = new Tree(7);

        int completeNumber = getCompleteNumber(head);
        System.out.println(completeNumber);
    }

    public static int getCompleteNumber(Tree head){
        if(head == null) return 0;

        return getNumber(head,1,getHight(head,1));
    }

    /**
     *
     * @param head 当前节点
     * @param level 当前节点层数
     * @param h 总高度
     * @return
     */
    public static int getNumber(Tree head,int level,int h){
        if(level == h) return 1;
        int hight = getHight(head.right,level+1);
        if(hight == h){
            return (1<<(h-level)) + getNumber(head.right,level+1,h);
        }else {
            return (1<<(h-level-1)) + getNumber(head.left,level+1,h);
        }
    }

    /**
     *
     * @param head 当前节点
     * @param level 当前节点所在层数
     * @return
     */
    public static int getHight(Tree head,int level){
        while(head!=null){
            level++;
            head = head.left;
        }
        return level - 1;
    }
}
