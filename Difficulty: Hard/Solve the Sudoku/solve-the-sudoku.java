class Solution {

    static boolean isSafe(int[][] mat, int row, int col, int num){

        // Row Check
        for(int j=0;j<9;j++){
            if(mat[row][j] == num){
                return false;
            }
        }

        // Column Check
        for(int i=0;i<9;i++){
            if(mat[i][col] == num){
                return false;
            }
        }

        // 3x3 Grid Check
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                if(mat[startRow+i][startCol+j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean solve(int[][] mat){

        int row = -1;
        int col = -1;
        boolean found = false;

        // Find empty cell
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(mat[i][j] == 0){
                    row = i;
                    col = j;
                    found = true;
                    break;
                }
            }

            if(found) break;
        }

        // Base Case
        if(!found){
            return true;
        }

        // Try 1 to 9
        for(int num=1; num<=9; num++){

            if(isSafe(mat,row,col,num)){

                // Choose
                mat[row][col] = num;

                // Explore
                if(solve(mat)){
                    return true;
                }

                // Undo
                mat[row][col] = 0;
            }
        }

        return false;
    }

    static void solveSudoku(int[][] mat) {
        solve(mat);
    }
}