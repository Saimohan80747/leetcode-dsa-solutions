class Solution {
    

    public int[] findOrder(int numCourses, int[][] p) {
        int V=numCourses;
        ArrayList<Integer>[] adj=new ArrayList[V];
        ArrayList<Integer> lst=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        int[] indeg=new int[V];
        for(int[] edge:p){
             indeg[edge[0]]++;
             adj[edge[1]].add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            lst.add(node);
            for(int ne:adj[node]){
                indeg[ne]--;
                if(indeg[ne]==0) q.add(ne);
            }
        }
        if(lst.size()!=V) return new int[]{};
        int[] ans=new int[V];
        for(int i=0;i<V;i++){
            ans[i]=lst.get(i);
        }
        return ans;
    }
}