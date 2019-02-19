package com.liyi.algorithm.hash;

public class SearchWord2DMatrix {
    public static void main(String[] args) {
        String temp = "123";

        System.out.println(temp.substring(1,temp.length()));
    }
    public static boolean search(char[][] board,String word ){
        if(board == null || board.length == 0 || board.length * board[0].length < word.length()) return false;
        int lenX = board.length;
        int lenY = board[0].length;
        char temp = word.charAt(0);
        String sub = word.substring(1,word.length());
        for(int i =0;i<lenX;i++){
            for(int j=0;j<lenY;j++){
                if(board[i][j] == temp){
                    if("".equals(sub)){
                        return true;
                    }else{
                        return searchFlag(board,i,j,word.substring(1,word.length()));
                    }
                }
            }
        }
        return false;
    }
    public static boolean searchFlag(char[][] board,int i, int j,String word){
        return false;
    }
}
