class Solution {
    List<Integer> ans=new ArrayList<>();
    void dfs_for_bug(int k,ArrayList<Integer>[] adj,boolean[] isBug,boolean[] vis){
        isBug[k]=true;
        vis[k]=true;
        for(int a:adj[k]){
            if(!vis[a]){
                dfs_for_bug(a,adj,isBug,vis);
            }
        }

    }
    boolean dfs(int nd,ArrayList<Integer>[] adj,boolean[] isBug,boolean[] vis){
        vis[nd]=true;
        ans.add(nd);
        for(int a:adj[nd]){
            if(!vis[a]){
                if(isBug[a]) return true;
                if(dfs(a,adj,isBug,vis)) return true;
            }
        }
        return false;
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] e:invocations){
            adj[e[0]].add(e[1]);
        }
        boolean[] isBug=new boolean[n];
        boolean[] vis=new boolean[n];
        dfs_for_bug(k,adj,isBug,vis);
        vis=new boolean[n];
        for(int i=0;i<n;i++){
           if(!vis[i] && !isBug[i]){
              if(dfs(i,adj,isBug,vis)){
                ans=new ArrayList<>();
                for(int j=0;j<n;j++) ans.add(j);
                return ans;
               }
           }
        }
        return ans;
    }
}