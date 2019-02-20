package com.liyi.algorithm.hash;

/**
 * 给一个二维矩阵 char[][]，在其中寻找是否还有某个单词
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 */
public class SearchWord2DMatrix {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},
                                      {'S','F','C','S'},
                                      {'A','D','E','E'}};

        System.out.println(search(board,"ABCESES"));
    }
    public static boolean search(char[][] board,String word ){
        if(board == null || board.length == 0 || board.length * board[0].length < word.length()) return false;
        int lenX = board.length;
        int lenY = board[0].length;
        int index = 0;
        boolean[][] valid = new boolean[lenX][lenY];
        for(int i =0;i<lenX;i++){
            for(int j=0;j<lenY;j++){
                if(board[i][j] == word.charAt(index)){
                       if(searchFlag(board,valid,i,j,word,index)){
                          return true;
                       }
                }
            }
        }
        return false;
    }
    public static boolean searchFlag(char[][] board,boolean[][] valid,int i, int j,String word,int index){
        if(index == word.length()) return true;
        if(i<0 || j >= board[0].length || j < 0 || i>=board.length || board[i][j] != word.charAt(index) || valid[i][j]) return false;

        valid[i][j] = true;
        boolean flag1 = searchFlag(board,valid,i-1,j,word,index+1);//上
        if(flag1) return true;
        boolean flag2 = searchFlag(board,valid,i+1,j,word,index+1);//下
        if(flag2) return true;
        boolean flag3 = searchFlag(board,valid,i,j-1,word,index+1);//左
        if(flag3) return true;
        boolean flag4 = searchFlag(board,valid,i,j+1,word,index+1);//右
        if(flag4) return true;
        valid[i][j] = false;//当前的不可以也不影响下一个使用
        return false;
    }
}
