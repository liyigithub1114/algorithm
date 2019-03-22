package com.liyi.algorithm.tree;

/**
 *
 */
public class PopulatingNextRightPointersInEachNode {

    public Node1 connect(Node1 root){
        if(root == null) return root;
        connect(root,null);
        return root;
    }

    public void connect(Node1 left,Node1 right){
        if(left == null && right == null) return ;
        if(left != null && right == null){
            left.next = null;
            connect(left.left, left.right);
        }
        if(left ==null && right != null){
            right.next = null;
            connect(right.left,right.right);
        }
        if(left != null && right != null){
            left.next = right;
            connect(left.left, left.right);
            connect(left.right, right.left);
            if(left.right != null && left.right.next == null){
                connect(left.right,right.right);
            }
            connect(right.left, right.right);
            connect(right.right, null);
        }
    }
}
