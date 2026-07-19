class Solution {
    int node=0;
    int[] dx={1,1,-1,-1,2,2,-2,-2};
    int[] dy={2,-2,2,-2,1,-1,1,-1};
    int cal_node(int i,int j){return 8*(i-1)+j;}

    void paths(ArrayList<Integer>[] adj,int i,int j){
       int node=cal_node(i,j);
       for(int k=0;k<8;k++){
           int nx=i+dx[k];
           int ny=j+dy[k];
           int nn=cal_node(nx,ny);
           if(nx>0 && ny>0 && nx<=8 && ny<=8) adj[node].add(nn);
       }
    }
    public boolean canReach(int[] start, int[] target) {
        int nd1=cal_node(start[0]+1,start[1]+1);
        int nd2=cal_node(target[0]+1,target[1]+1);
        if(nd1==nd2) return true;
        ArrayList<Integer>[] adj=new ArrayList[65];
        for(int i=0;i<65;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                paths(adj,i,j);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[65];
        q.add(nd1);
        int level=0;
        while(!q.isEmpty()){
            level++;
            int n=q.size();
            for(int i=0;i<n;i++){
                int nd=q.poll();
                vis[nd]=true;
                for(int ne:adj[nd]){
                    if(ne==nd2) return level%2==0;
                    if(!vis[ne]) q.add(ne);
                }
                
            }
        }
        return false;
        
        
    }
}