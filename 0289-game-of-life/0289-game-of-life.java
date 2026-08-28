class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length,m=board[0].length;
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               mat[i][j]=board[i][j];
            }
        }
        int[] dx={1,-1,0,0,1,-1,1,-1};
        int[] dy={0,0,1,-1,1,-1,-1,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int cnt=0;
                for(int k=0;k<8;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx<n && nx>-1 && ny<m && ny>-1 && board[nx][ny]==1) cnt++;
                }
                if(board[i][j]==1 && (cnt<2 || cnt>3)) mat[i][j]=0;
                else if(board[i][j]==0 && cnt==3) mat[i][j]=1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               board[i][j]=mat[i][j];
            }
        }
    }
}