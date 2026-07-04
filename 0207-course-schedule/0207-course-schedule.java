class Solution {
    boolean detectCycle( boolean[] vis,boolean[] pvis,ArrayList<Integer>[] adj,int curr){
        vis[curr]=true;
        pvis[curr]=true;
        for(int a:adj[curr]){
            if(pvis[a]) return true;
            if(!vis[a]){
                if(detectCycle(vis,pvis,adj,a)) return true;
            }
        }
        
        return pvis[curr]=false;
    }
    public boolean canFinish(int numCourses, int[][] p) {
        int V=numCourses;
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:p){
             adj[edge[1]].add(edge[0]);
        }
        boolean[] vis=new boolean[V];
        boolean[] pvis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(detectCycle(vis,pvis,adj,i)) return false;
            }
        }
        return true;

    }
}