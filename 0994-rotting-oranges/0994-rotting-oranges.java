class Solution {
    int[] dx={0,-1,0,1};
    int[] dy={1,0,-1,0};
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
             if(grid[i][j]==2){
                q.add(new int[]{i,j});
             }
           }
        }
        int ans=0;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int[] p=q.poll();
                int x=p[0];
                int y=p[1];
                for(int j=0;j<4;j++){
                    int nx=x+dx[j];
                    int ny=y+dy[j];
                    if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        q.add(new int[]{nx,ny});
                    }
                } 
            }
            if(!q.isEmpty()) ans++;
            
        }
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
             if(grid[i][j]==1){
                return -1;
             }
           }
        }
        return ans;
    }
}