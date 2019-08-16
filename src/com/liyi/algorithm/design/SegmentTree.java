package com.liyi.algorithm.design;

public class SegmentTree {
    public static void main(String[] args) {

    }

    //线性树的构建
    public SegmentTreeNode build(int[] A) {
        return helper(A, 0, A.length - 1);
    }

    public SegmentTreeNode helper(int[] A, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new SegmentTreeNode(start, end, A[start]);
        }

        int mid = start + (end - start) / 2;

        SegmentTreeNode node = new SegmentTreeNode(start, end, -1);

        if(start != end){
            SegmentTreeNode left = helper(A, start, mid);
            SegmentTreeNode right = helper(A, mid + 1, end);

            if(left != null){
                node.left = left;
                node.max = Math.max(left.max, node.max);
            }

            if(right != null){
                node.right = right;
                node.max = Math.max(right.max, node.max);
            }
        }
        return node;
    }

    //线性树的查询
    public static int query(SegmentTreeNode root, int start, int end) {
        if(start == root.start && end == root.end){
            return root.max;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        if(start <= mid){
            if(mid < end){
                leftMax = query(root.left, start, mid);
            }else{
                leftMax = query(root.left, start, end);
            }
        }

        if(mid < end){
            if(start <= mid){
                rightMax = query(root.right, mid + 1, end);
            }else{
                rightMax = query(root.right, start, end);
            }
        }

        return Math.max(leftMax, rightMax);
    }

    //线段树的修改
    public static void modify(SegmentTreeNode root, int index, int value) {
        if(root.start == index && root.end == index){
            root.max = value;
            return ;
        }

        int mid = root.start + (root.end - root.start) / 2;

        if(root.start <= index && index <= mid){
            modify(root.left, index, value);
        }

        if(mid < index && index <= root.end){
            modify(root.right, index, value);
        }

        root.max = Math.max(root.left.max, root.right.max);
    }
}
class SegmentTreeNode {
      public int start, end, max;
      public SegmentTreeNode left, right;
      public SegmentTreeNode(int start, int end, int max) {
          this.start = start;
          this.end = end;
          this.max = max;
          this.left = this.right = null;
      }
  }