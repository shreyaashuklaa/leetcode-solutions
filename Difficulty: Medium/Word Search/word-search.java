class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int rows=mat.length;
        int cols=mat[0].length;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(mat, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] mat, String word, int row, int col, int index, boolean[][] visited){
        if(index==word.length()){       //entire word is matched
            return true;
        }
        if(row<0 || row>=mat.length || col<0 || col>=mat[0].length){               //out of bounds
            return false;
        }
        if(visited[row][col]){               //already visited
            return false;
        }
        if(mat[row][col]!=word.charAt(index)){         //character mismatch
            return false;
        }
        visited[row][col]=true;                        //MARK VISITED
        boolean found=dfs(mat, word, row-1, col, index+1, visited)||     //UP
        dfs(mat, word, row+1, col, index+1, visited)||                   //DOWN
        dfs(mat, word, row, col-1, index+1, visited)||                   //LEFT
        dfs(mat, word, row, col+1, index+1, visited);                    //RIGHT
        
        //Backtrack
        visited[row][col]=false;
        return found;
    }
    
}