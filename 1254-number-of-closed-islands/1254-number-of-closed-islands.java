class Solution {
    void dfs(int[][] arr,int x,int y,int n,int m){
        if(x<0 || x==n || y<0 || y==m || arr[x][y]==1) return;
        arr[x][y]=1;
        dfs(arr,x+1,y,n,m);
        dfs(arr,x-1,y,n,m);
        dfs(arr,x,y+1,n,m);
        dfs(arr,x,y-1,n,m);
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length,m=grid[0].length,ans=0;
        for(int i=0;i<n;i++){
            dfs(grid,i,0,n,m);
            dfs(grid,i,m-1,n,m);
        }
        for(int i=0;i<m;i++){
            dfs(grid,0,i,n,m);
            dfs(grid,n-1,i,n,m);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    ans++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return ans;

    }
}