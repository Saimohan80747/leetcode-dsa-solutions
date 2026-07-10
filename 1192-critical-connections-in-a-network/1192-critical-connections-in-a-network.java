class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    int t=0;
    void dfs( ArrayList<Integer>[] adj,boolean vis[],int[] time,int[] low,int nd,int prev){
        vis[nd]=true;
        time[nd]=t;
        low[nd]=t++;
        for(int ne:adj[nd]){
            if(ne==prev) continue;
            if(!vis[ne]){
                dfs(adj,vis,time,low,ne,nd);

                low[nd]=Math.min(low[nd],low[ne]);
                if(time[nd]<low[ne]){
                    ans.add(Arrays.asList(nd,ne));
                }
            }
            else{
                low[nd]=Math.min(low[nd],time[ne]);
            }
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(List<Integer> c:con){
            adj[c.get(0)].add(c.get(1));
            adj[c.get(1)].add(c.get(0));
        }
        boolean[] vis=new boolean[n];
        int[] time=new int[n];
        int[] low=new int[n];
        dfs(adj,vis,time,low,0,-1);
        // for(int i=0;i<n;i++){
        //     System.out.print(low[i]+" ");
        // }
        return ans;
    }
}