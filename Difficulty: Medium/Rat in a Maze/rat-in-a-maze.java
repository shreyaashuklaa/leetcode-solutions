class Solution {
    static boolean isSaretoMove(int newX, int newY, int n, int[][] maze, boolean[][] visited) {
        if(newX<0 || newX>=n || newY<0 || newY>=n){    //out of bound case 
            return false;
        }
        else if(maze[newX][newY]==0){     //Blocked cell pr jaare 
            return false;
        }
        else if(visited[newX][newY]==true){    //already visit krliya h cell ko
            return false;
        }
        else 
        return true;
    }
    static void solve(int[][] maze, int srcX, int srcY, int destX, int destY, boolean[][] visited, ArrayList<String> ans, String path){
        //BASE CASE
        if(srcX==destX && srcY==destY){
            ans.add(path);
            return;
        }
        visited[srcX][srcY]=true;
        int n=maze.length;
        //4movements
        //up
        int newX=srcX-1;
        int newY=srcY;
        if(isSaretoMove(newX, newY, n, maze, visited)){
            solve(maze, newX, newY, destX, destY, visited, ans, path + "U");
        }
        //down
        newX=srcX+1;
        newY=srcY;
        if(isSaretoMove(newX, newY, n, maze, visited)){
            solve(maze, newX, newY, destX, destY, visited, ans, path + "D");
        }
        //left
        newX=srcX;
        newY=srcY-1;
        if(isSaretoMove(newX, newY, n, maze, visited)){
            solve(maze, newX, newY, destX, destY, visited, ans, path + "L");
        }
        //right
        newX=srcX;
        newY=srcY+1;
        if(isSaretoMove(newX, newY, n, maze, visited)){
            solve(maze, newX, newY, destX, destY, visited, ans, path + "R");
        }
        //BACKTRACKING 
        visited[srcX][srcY]=false;
        
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        int srcX=0;  // source row
        int srcY=0;  //source column
        int n=maze.length;
        int destX=n-1;  //dest row
        int destY=n-1;  //dest column
        boolean[][] visited=new boolean[n][n];
        ArrayList<String> ans=new ArrayList<>();
        String path="";
        
        //if src location or destination is a blocked cell
        if(maze[0][0]==0 || maze[n-1][n-1]==0){
            return ans;
        } 
        solve(maze, srcX, srcY, destX, destY, visited, ans, path);
        Collections.sort(ans);
        return ans;
    }
}