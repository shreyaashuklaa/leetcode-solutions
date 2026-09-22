class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // Try starting from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board,
                        String word,
                        int row,
                        int col,
                        int index,
                        boolean[][] visited) {

        // Base Case:
        // Entire word matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Already visited
        if (visited[row][col]) {
            return false;
        }

        // Character mismatch
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark visited
        visited[row][col] = true;

        // Explore 4 directions
        boolean found =
                dfs(board, word, row - 1, col, index + 1, visited) || // Up
                dfs(board, word, row + 1, col, index + 1, visited) || // Down
                dfs(board, word, row, col - 1, index + 1, visited) || // Left
                dfs(board, word, row, col + 1, index + 1, visited);   // Right

        // Backtrack
        visited[row][col] = false;

        return found;
    }
}