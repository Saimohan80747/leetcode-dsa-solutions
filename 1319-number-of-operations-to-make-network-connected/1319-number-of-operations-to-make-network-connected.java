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
    int getComponents(){
        
        int components=0;
        for(int i=0;i<n;i++){
            if(par[i]==i) components++;
        }
        return components;
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
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        DisjointSet ds=new DisjointSet(n);
        for(int[] c:connections){
            ds.union(c[0],c[1]);
        }

        return ds.getComponents()-1;




    }
}