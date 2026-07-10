class DisjointSet{
    int[] par;
    int[] rank;
    int n;
    DisjointSet(int V){
        par=new int[V];
        rank=new int[V];
        n=V;
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    int max_stones_removed(){
        int ans=0;
        int[] cnt=new int[n];
        for(int i=0;i<n;i++){
            if(par[i]!=i) cnt[par[i]]++;
        }
        for(int i=0;i<n;i++){
            ans+=cnt[i];
        }

        return ans;
    }
    int findpar(int node){
        if(node==par[node]) return node;
        return par[node]=findpar(par[node]);
    }
    void union(int a,int b){
        int ul_a=findpar(a);
        int ul_b=findpar(b);
        if(ul_a==ul_b) return;
        if(rank[ul_a]>rank[ul_b]){
            par[ul_b]=ul_a;
        }else if(rank[ul_a]<rank[ul_b]){
             par[ul_a]=ul_b;
        }else{
            par[ul_b]=ul_a;
            rank[ul_a]++;
        }
    }


}

class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<n;i++){
            int s1[]=stones[i];
            for(int j=i+1;j<n;j++){
                int s2[]=stones[j];
                if(s1[0]==s2[0] || s1[1]==s2[1]) ds.union(i,j);
            }
        }
        return ds.max_stones_removed();
    }
}