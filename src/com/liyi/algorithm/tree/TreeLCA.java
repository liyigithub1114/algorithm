package com.liyi.algorithm.tree;

/**
 * 求二叉树的最低组元素，给定两个节点，获取这两个节点共同最近的父元素
 */
public class TreeLCA {
    public static void main(String[] args) {
        Tree head = new Tree(3);
        head.left = new Tree(5);
        head.right = new Tree(1);
        head.left.left = new Tree(6);
        head.left.right = new Tree(2);
        head.left.right.left = new Tree(7);
        head.left.right.right = new Tree(4);
        head.right.left = new Tree(0);
        head.right.right = new Tree(8);
        System.out.println(lca(head,head.left,head.left.right.right).value);;
    }

    public static Tree lca(Tree root,Tree p,Tree q){
        if(root == null) return null;
        //本体包含 t1,t2.左右不完全包含t1,t2 即为最低
        if(isContain(root,p) && isContain(root,q)){
            if(isContain(root.left,p) && isContain(root.left,q)){
                return lca(root.left,p,q);
            }else if(isContain(root.right,p) && isContain(root.right,q)){
                return lca(root.right,p,q);
            }else{
                return root;
            }
        }
        return null;
    }

    public static boolean isContain(Tree tree,Tree t){
        if(tree == null) return false;
        if(tree == t) return true;
        return isContain(tree.left,t) || isContain(tree.right,t);
    }


    public Tree lowestCommonAncestor(Tree root, Tree p, Tree q) {
        if(root==null){
            return root;
        }
        if(p==null && q!=null){
            return q;
        }
        if(p!=null && q==null){
            return p;
        }
        if(isin(p,q)){
            return p;
        }
        if(isin(q,p)){
            return q;
        }
        if((isleft(root,p)&& !isleft(root,q)) || (!isleft(root,p)&& isleft(root,q))){
            return root;
        }
        if(isleft(root,p)&& isleft(root,q)){
            return lowestCommonAncestor(root.left,p,q);
        }
        return lowestCommonAncestor(root.right,p,q);
    }

    public boolean isin(Tree root, Tree p){
        if(root==null){
            return false;
        }
        if(p==null){
            return true;
        }
        if(root==p){
            return true;
        }
        if(root.left!=null){
            if(root.left==p){
                return true;
            }
        }
        if(root.right!=null){
            if(root.right==p){
                return true;
            }
        }
        return isin(root.right,p)||(isin(root.left,p));
    }

    public boolean isleft(Tree root, Tree p){
        return isin(root.left,p);
    }
}
