class Solution {
    void dfs(char[][] b,boolean[][] vis,int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || b[i][j]=='X') return;
        vis[i][j]=true;
        dfs(b,vis,i+1,j,n,m);
        dfs(b,vis,i-1,j,n,m);
        dfs(b,vis,i,j+1,n,m);
        dfs(b,vis,i,j-1,n,m);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(board,vis,i,0,n,m);
        }
        for(int i=0;i<n;i++){
           dfs(board,vis,i,m-1,n,m);
        }
        for(int i=1;i<m-1;i++){
           dfs(board,vis,0,i,n,m);
        }
        for(int i=1;i<m-1;i++){
            dfs(board,vis,n-1,i,n,m);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j]) board[i][j]='X';
            }
        }
    }
}