class DisjointSet{
    int[] par;
    int[] size;
    int components;
    int n;
    DisjointSet(int V){
        par=new int[V];
        size=new int[V];
        n=V;
        components=n;
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
    }
    int findpar(int node){
        while(node!=par[node]){
            par[node]=par[par[node]];
            node=par[node];
        }
        return node;
    }
    void union(int a,int b){
        int ul_a=findpar(a);
        int ul_b=findpar(b);
        if(ul_a==ul_b) return;
        components--;
        if(size[ul_a]>size[ul_b]){
            par[ul_b]=ul_a;
            size[ul_a]+=size[ul_b];
        }else{
            par[ul_a]=ul_b;
            size[ul_b]+=size[ul_a];
        }
    }


}

class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DisjointSet ds=new DisjointSet(n);
        int[] row = new int[10001];
        int[] col = new int[10001];

        Arrays.fill(row,-1);
        Arrays.fill(col,-1);
        for(int i=0;i<n;i++){
            
            if(row[stones[i][0]]==-1)
                row[stones[i][0]]=i;
            else
                ds.union(i,row[stones[i][0]]);
            
            if(col[stones[i][1]]==-1)
                col[stones[i][1]]=i;
            else
                ds.union(i,col[stones[i][1]]);
        }

        return n-ds.components;
    }
}