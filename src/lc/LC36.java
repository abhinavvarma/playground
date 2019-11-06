package lc;

public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                } else if (rowCheck[board[i][j] - '1']) {
                    return false;
                } else {
                    rowCheck[board[i][j] - '1'] = true;
                }
                if (board[j][i] == '.') {
                } else if (colCheck[board[j][i] - '1']) {
                    return false;
                } else {
                    colCheck[board[j][i] - '1'] = true;
                }
                int m = i / 3 * 3 + j / 3;
                int n = i % 3 * 3 + j % 3;
                if (board[m][n] == '.') {
                } else if (boxCheck[board[m][n] - '1']) {
                    return false;
                } else {
                    boxCheck[board[m][n] - '1'] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '.', '.', '4', '.', '.', '.', '6', '3', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
                { '.', '.', '.', '5', '6', '.', '.', '.', '.' },
                { '4', '.', '3', '.', '.', '.', '.', '.', '1' },
                { '.', '.', '.', '7', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }
        };
        LC36 l = new LC36();
        l.isValidSudoku(board);
    }
}
