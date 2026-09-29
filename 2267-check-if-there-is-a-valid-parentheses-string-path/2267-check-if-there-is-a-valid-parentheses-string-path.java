class Solution {

    boolean dfs(char[][] grid,boolean[][][] dp,int i,int j,int cnt,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m) return false;
        if(i==n-1 && j==m-1) return cnt==1;
        if(cnt==0 && grid[i][j]==')'){
            dp[i][j][cnt]=true;
            return false;
        }
        if(dp[i][j][cnt]) return false;
        if(grid[i][j]=='('){
             if(dfs(grid,dp,i+1,j,cnt+1,n,m) || dfs(grid,dp,i,j+1,cnt+1,n,m)) return true;
        }else{
             if(dfs(grid,dp,i+1,j,cnt-1,n,m) || dfs(grid,dp,i,j+1,cnt-1,n,m)) return true;
        }
        dp[i][j][cnt]=true;
        return false;
    }
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[n-1][m-1]=='(' || grid[0][0]==')' || (n+m)%2==0) return false;
        boolean[][][] dp=new boolean[n+2][m+2][n+m];
        return dfs(grid,dp,0,0,0,n,m);
    }
}