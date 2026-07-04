
class Solution {
    public boolean bfs(int i,int c[],int[][] graph){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        c[i]=0;
        while(!q.isEmpty()){
            int n=q.poll();
            for(int a:graph[n]){
                if(c[n]==0){
                     if(c[a]==-1){
                        c[a]=1;
                        q.add(a);
                    }
                     if(c[a]==0) return false;
                     
                }
                else if(c[n]==1){
                     if(c[a]==-1) {
                        c[a]=0;
                        q.add(a);
                     }
                     if(c[a]==1) return false;
                    
                }
                else{}
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int c[]=new int[V];
        boolean ans=true;
        for(int i=0;i<V;i++) c[i]=-1;
        for(int i=0;i<V;i++){
            if(c[i]==-1){
                ans=ans && bfs(i,c,graph);
                if(!ans) return false;
            }
        }

        return true;

    }
}