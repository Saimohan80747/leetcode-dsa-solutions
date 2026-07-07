class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] t:times){
            adj[t[0]-1].add(new int[]{t[1]-1,t[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dis[]=new int[n];
        
        Arrays.fill(dis,Integer.MAX_VALUE);
        
        dis[k-1]=0;
        pq.add(new int[]{k-1,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            for(int[] ne:adj[arr[0]]){
                if(dis[ne[0]]>dis[arr[0]]+ne[1]){
                    dis[ne[0]]=dis[arr[0]]+ne[1];
                    pq.add(new int[]{ne[0],dis[ne[0]]});
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(dis[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dis[i]);
        }
        return max;

    }
}