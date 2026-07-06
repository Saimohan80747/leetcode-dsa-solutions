class Solution {
    double ans=0;
    void dfs(int node,int prev,double p,int tar,int t,ArrayList<Integer>[] adj){
        
        int poss=0;
        poss=adj[node].size();
        if(node!=1) poss--;
        if(t==0||poss==0){
            if(node==tar) ans=p;
            return;
        }


        for(int ne:adj[node]){
            if(ne!=prev) dfs(ne,node,p/poss,tar,t-1,adj);
        }

        

    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfs(1,-1,1.0,target,t,adj);
        return ans;

    }
}