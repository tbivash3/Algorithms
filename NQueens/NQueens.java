package NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        solveNQueens(new int[n][n], 0, result);

        return result;
    }

    private static void solveNQueens(int[][] board, int row, List<List<String>> result) {

        if (row == board.length) {
            result.add(addBoardConfig(board));
            return;
        }

        for (int column = 0; column < board.length; column++) {

            if (!isPostitionAttacked(board, row, column)) {
                board[row][column] = 1;
                solveNQueens(board, row + 1, result);
                board[row][column] = 0;
            }
        }

    }

    private static List<String> addBoardConfig(int[][] board) {
        List<String> list = new ArrayList<>();

        for (int[] arr : board) {
            String config = "";
            for (int pos : arr) {
                if (pos == 0) {
                    config += ".";
                } else {
                    config += "Q";
                }
            }
            list.add(config);
        }

        return list;

    }

    private static boolean isPostitionAttacked(int[][] board, int row, int column) {

        boolean occupied = false;
        int n = board.length;

        for (int i = 0; i < n; i++) {
            if (board[i][column] == 1) return true;
        }
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 1) return true;
        }

        //Bottom Right
        int curRow = row + 1;
        int curCol = column + 1;

        while (curRow < n && curCol < n) {
            if (board[curRow][curCol] == 1) {
                return true;
            }
            curRow++;
            curCol++;
        }

        curRow = row - 1;
        curCol = column + 1;

        // Top Right
        while (curRow >= 0 && curCol < n) {
            if (board[curRow][curCol] == 1) {
                return true;
            }
            curRow--;
            curCol++;
        }


        //Bottom Left
        curRow = row + 1;
        curCol = column - 1;


        while (curRow < n && curCol >= 0) {
            if (board[curRow][curCol] == 1) {
                return true;
            }
            curRow++;
            curCol--;
        }

        // Top Left
        curRow = row - 1;
        curCol = column - 1;

        while (curRow >= 0 && curCol >= 0) {
            if (board[curRow][curCol] == 1) {
                return true;
            }
            curRow--;
            curCol--;
        }

        return occupied;
    }

    public static void main(String[] args) {
        solveNQueens(100).size();
    }
}
