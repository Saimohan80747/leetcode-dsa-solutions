class Solution {
    int[] dx={1,0,0,-1};
    int[] dy={0,1,-1,0};
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                   q.add(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int x=arr[0];
            int y=arr[1];
            int dis=arr[2];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && mat[nx][ny]==1 && ans[nx][ny]==0){
                    ans[nx][ny]=dis+1;
                    q.add(new int[]{nx,ny,dis+1});
                }
            }
        }
        return ans;
    }
}