class DisjointSet{
    int[] par;
    int[] rnk;
    int n=0;
    DisjointSet(int V){
       par=new int[V+1];
       rnk=new int[V+1];
       n=V+1;
       for(int i=0;i<=V;i++){
          par[i]=i;
       }
    }
    // void p(){
    //     for(int i=0;i<n;i++){
    //         System.out.print(par[i]+" ");
    //     }
    //     System.out.println();
    //     for(int i=0;i<n;i++){
    //         System.out.print(rnk[i]+" ");
    //     }
    // }
    int findpar(int node){
        if(node==par[node]) return node;
        return par[node]=findpar(par[node]);
    }

    void union(int a,int b){
        int ulpar_a=findpar(a);
        int ulpar_b=findpar(b);
        if(ulpar_a==ulpar_b) return;
        if(rnk[ulpar_a]>rnk[ulpar_b]){
            par[ulpar_b]=ulpar_a;
        }else if(rnk[ulpar_a]<rnk[ulpar_b]){
            par[ulpar_a]=ulpar_b;
        }else{
            par[ulpar_a]=ulpar_b;
            rnk[ulpar_a]++;
        }
    }
}

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
      
        boolean[] ans=new boolean[queries.length];
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]<=maxDiff) ds.union(i,i+1);
        }
        // ds.p();
        for(int i=0;i<queries.length;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            if(ds.findpar(x)==ds.findpar(y)) ans[i]=true;
        }
      


        
       return ans;
        
    }
}