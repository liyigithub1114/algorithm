package com.liyi.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AllTreePath {

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.right = new Tree(5);
        binaryTreePaths(tree);
    }

    public static List<String> binaryTreePaths(Tree root) {
        if(root == null) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        getAllPath(root,res,"");
        System.out.println(res);
        return res;
    }
    public static List<String> getAllPath(Tree root,List<String> res,String s){
        if(root == null){
            res.add(s);
            return res;
        }
        if(!"".equals(s)){
            s+="->";
        }
        if(root.left == null && root.right != null){
            getAllPath(root.right,res,s+root.value);
        }else if(root.left != null && root.right == null){
            getAllPath(root.left,res,s+root.value);
        }else if(root.left == null && root.right == null){
            getAllPath(root.left,res,s+root.value);
        }else if(root.left != null && root.right != null){
            getAllPath(root.left,res,s+root.value);
            getAllPath(root.right,res,s+root.value);
        }
        return res;
    }
}
