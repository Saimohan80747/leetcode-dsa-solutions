class Solution {
    int MOD=(int)(1e9+7);
    int dfs(int[][] arr, int[][][] dp,int isDown,int x,int y,int n,int m){
        if(x<0 || x>=n || y<0 || y>=m) return 0;
        if(x==n-1 && y==m-1) return 1;
        if(dp[x][y][isDown]!=Integer.MAX_VALUE) return dp[x][y][isDown];
        if(arr[x][y]==1){
            if(isDown==1) return dp[x][y][isDown]=dfs(arr,dp,0,x+1,y,n,m)%MOD;
            return dp[x][y][isDown]=dfs(arr,dp,1,x,y+1,n,m)%MOD;  
        }
        return  dp[x][y][isDown]=dfs(arr,dp,0,x+1,y,n,m)%MOD+dfs(arr,dp,1,x,y+1,n,m)%MOD;
    }
    public int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp= new int[n][m][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j][0]=Integer.MAX_VALUE;
                dp[i][j][1]=Integer.MAX_VALUE;
            }
        }
        return dfs(grid,dp,0,0,0,n,m)%MOD;
    }
}