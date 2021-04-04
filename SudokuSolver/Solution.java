package SudokuSolver;

public class Solution {
    public static void solveSudoku(char[][] board) {

        solve(board, 0, 0);
    }

    public static boolean solve(char[][] board, int row, int column) {

        if(row == board.length) return true;

        if (board[row][column] != '.') {
            int[] nextPos = getNextPosition(board, row, column);
            return solve(board, nextPos[0], nextPos[1]);

        } else {
            for (int j = 1; j <= 9; j++) {

                char entry = Character.forDigit(j, 10);

                if (isValidEntry(board, row, column, entry)) {

                    board[row][column] = entry;

                    int[] nextPos = getNextPosition(board, row, column);

                    boolean isSolved = solve(board, nextPos[0], nextPos[1]);

                    if(isSolved) return true;

                    board[row][column] = '.';

                }
            }
            return false;
        }
    }


    public static int[] getNextPosition(char[][] board, int row, int column) {
        if (column == board[row].length - 1) {
            row = row + 1;
            column = 0;
        } else {
            column++;
        }

        return new int[]{row, column};
    }


    public static boolean isValidEntry(char[][] board, int row, int column, char currentNum) {

        boolean isRowValid = validateRow(board, row, currentNum);
        if (!isRowValid) return false;

        boolean isColumnValid = validateColumn(board, column, currentNum);
        if (!isColumnValid) return false;

        row = findStartIndex(row);
        column = findStartIndex(column);

        boolean isBoxValid = validateBox(board, row, column, currentNum);

        return isBoxValid;

    }

    public static boolean validateBox(char[][] board, int row, int column, char currentNum) {

        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (board[i][j] == currentNum) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean validateRow(char[][] board, int row, char currentNum) {
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] == currentNum) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateColumn(char[][] board, int column, char currentNum) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == currentNum) {
                return false;
            }
        }
        return true;
    }

    public static int findStartIndex(int index) {
        if (index <= 2) return 0;
        if (index > 5) return 6;
        return 3;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);

    }


}
