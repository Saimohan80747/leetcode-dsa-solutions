class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx={0,-1,1,0,1,-1,1,-1};
        int[] dy={-1,0,0,1,1,-1,-1,1};
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[][] dis=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dis[i],Integer.MAX_VALUE);
        dis[0][0]=0;
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int x=arr[0];
            int y=arr[1];
            for(int i=0;i<8;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny]==0){
                    if(dis[nx][ny]>dis[x][y]+1){
                        dis[nx][ny]=dis[x][y]+1;
                        pq.add(new int[]{nx,ny,dis[nx][ny]});
                    }
                }
            }
        }
        if(dis[n-1][n-1]==Integer.MAX_VALUE) return -1;
        return dis[n-1][n-1]+1;
    }
}