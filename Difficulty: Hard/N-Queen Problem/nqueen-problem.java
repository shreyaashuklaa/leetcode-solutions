import java.util.*;
class Solution {
    static boolean isSafeToPlace(int rowIndex, int colIndex, int n, int[][] board) {
        // left row
        int row = rowIndex;
        int col = colIndex;
        while (col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            col--;
        }
        // upper-left diagonal
        row = rowIndex;
        col = colIndex;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }
        // lower-left diagonal
        row = rowIndex;
        col = colIndex;
        while (row < n && col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    static void solve(int[][] board, int n, int colIndex, ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans) {
        // Base Case
        if (colIndex >= n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            if (isSafeToPlace(rowIndex, colIndex, n, board)) {
                // place queen
                board[rowIndex][colIndex] = 1;
                path.add(rowIndex + 1);
                solve(board, n, colIndex + 1, path, ans);
                // backtrack
                path.remove(path.size() - 1);
                board[rowIndex][colIndex] = 0;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        int[][] board = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        solve(board, n, 0, path, ans);
        return ans;
    }
}