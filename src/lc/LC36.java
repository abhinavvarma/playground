package lc;

import utils.Display;

public class LC36 {
    public boolean isValidSudoku(Character[][] board) {
        for(int i = 0;i < 9;i++){
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];
            for(int j = 0;j< 9;j++){
                if(board[i][j] == '.'){}
                else if(rowCheck[board[i][j] - '1']) {
                    return false;
                } else rowCheck[board[i][j] - '1'] = true;
                if(board[i][j] == '.'){}
                else if(colCheck[board[i][j] - '1']) {
                    return false;
                } else colCheck[board[i][j] - '1'] = true;
                int m = i/3*3 + j/3;
                int n = i%3*3 + j%3;
                if(board[m][n] == '.') {}
                else if(boxCheck[board[m][n] - '1']) return false;
                else boxCheck[board[m][n] - '1'] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC36 l = new LC36();
        Character[][] ip = {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        (new Display<Character>()).print2dArray(ip);
        l.isValidSudoku(ip);
    }
}
