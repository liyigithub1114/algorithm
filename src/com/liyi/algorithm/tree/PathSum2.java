package com.liyi.algorithm.tree;

//     5
//    / \
//    4  8
//    /   / \
//    11  13  4
//    /  \    / \
//    7    2  5   1

//[1,-2,-3,1,3,-2,null,-1]
//2



import java.util.ArrayList;
import java.util.List;

/** sum = 22
 * [
    [5,4,11,2],
    [5,8,4,5]
 ]
 */
public class PathSum2 {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(-2);
        tree.right = new Tree(-3);
        tree.left.left = new Tree(1);
        tree.left.right = new Tree(3);
        tree.left.left.left = new Tree(-1);
        tree.right.left = new Tree(-2);
//        tree.left = new Tree(4);
//        tree.right = new Tree(8);
//        tree.left.left = new Tree(11);
//        tree.left.left.left = new Tree(7);
//        tree.left.left.right = new Tree(2);
//        tree.left.left.right.right = new Tree(0);
//        tree.right.left = new Tree(13);
//        tree.right.right = new Tree(4);
//        tree.right.right.left =  new Tree(5);
//        tree.right.right.left.left = new Tree(0);
//        tree.right.right.left.left.right = new Tree(0);
//        tree.right.right.right = new Tree(1);
        System.out.println(pathSum(tree,22));
    }

    public static List<List<Integer>> pathSum(Tree root,int sum){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root,res,new ArrayList<>(),2);
        return res;
    }

    public static void pathSum(Tree root,List<List<Integer>> res,List<Integer> list,int sum){
        if(root.left == null && root.right == null){
            if(sum  - root.value == 0){
                list.add(root.value);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return ;
        }
        Integer val = root.value;
        list.add(val);
        if(root.left != null){
            pathSum(root.left,res,list,sum-val);
        }
        if(root.right != null){
            pathSum(root.right,res,list,sum-val);
        }
        list.remove(list.size() - 1);
    }
}
