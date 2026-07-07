class Solution {
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] e:roads){
            adj[e[0]].add(new int[]{e[1],e[2]});
            adj[e[1]].add(new int[]{e[0],e[2]});
        }
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        long[] dis=new long[n];
        long[] ways=new long[n];
        Arrays.fill(ways,0);
        Arrays.fill(dis,Long.MAX_VALUE);
        pq.add(new long[]{0,0});
        ways[0]=1;
        dis[0]=0;
        while(!pq.isEmpty()){
            long[] arr=pq.poll();
            int u=(int)arr[0];
            if(arr[1]>dis[u]) continue;
            for(int[] ne:adj[u]){
                if(dis[ne[0]]>dis[u]+ne[1]){
                    ways[ne[0]]=ways[u];
                    dis[ne[0]]=dis[u]+ne[1];
                    pq.add(new long[]{(long)ne[0],dis[ne[0]]});
                }else if(dis[ne[0]]==dis[u]+ne[1]) ways[ne[0]] = (ways[ne[0]] + ways[u]) % 1000000007;
                
            } 
        }
        return (int)(ways[n-1]%1000000007);
    }
}