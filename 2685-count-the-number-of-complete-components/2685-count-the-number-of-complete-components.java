class DisjointSet{
    int[] par;
    int[] size;
    int[] edges;
    int n;
    DisjointSet(int V){
        par=new int[V];
        size=new int[V];
        edges=new int[V];
        n=V;
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
    }
    int findCompleteComponents(){
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int completeComponents=0;
        for(int i=0;i<n;i++){
            int root = findpar(i);
            map.put(root,map.getOrDefault(root,0)+edges[i]);
        }
        for(int p:map.keySet()){
           int E=map.get(p)/2;
           int V=size[p];
           if(E>=(V*(V-1))/2) completeComponents++;
        }
        return completeComponents;
    }
    int findpar(int node){
        if(par[node]==node) return node;
        return par[node]=findpar(par[node]);
    }
    void union(int a,int b){
        int ul_a=findpar(a);
        int ul_b=findpar(b);
        edges[a]++;
        edges[b]++;
        if(ul_a==ul_b) return;
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
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet ds=new DisjointSet(n);
        for(int[] e:edges){
            ds.union(e[0],e[1]);
        }
        return ds.findCompleteComponents();

    }
}