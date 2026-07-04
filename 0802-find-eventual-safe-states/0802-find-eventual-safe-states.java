class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer>[] adj=new ArrayList[V];
        int indeg[]=new int[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<V;i++){
           for(int a:graph[i]){
               indeg[i]++;
               adj[a].add(i);
           }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
           if(indeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int nd=q.poll();
            ans.add(nd);
            for(int ne:adj[nd]){
                indeg[ne]--;
                if(indeg[ne]==0) q.add(ne);
            }
        }
        Collections.sort(ans);
        return ans;

    }
}