class Solution {
    List<String> getNeighbors(String s){
        List<String> ans=new ArrayList<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<4;i++){
           char c=arr[i];
           arr[i]= c=='0'?'9':(char)(c-1);
           ans.add(new String(arr));
           arr[i]= c=='9'?'0':(char)(c+1);
           ans.add(new String(arr));
           arr[i]=c;
        }
        return ans;
    }
    public int openLock(String[] deadends, String target) {
        
        boolean[] vis=new boolean[10000];
        for(String s:deadends){
            vis[Integer.parseInt(s)]=true;
        }
        if(vis[0]) return -1;
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        vis[0]=true;
        int ans=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String s=q.poll();
                if(s.equals(target)) return ans;
                List<String> ne=getNeighbors(s);
                for(String a:ne){
                    if(!vis[Integer.parseInt(a)]){
                        q.add(a);
                        vis[Integer.parseInt(a)]=true;
                    }
                }
            }
            ans++;
        }

        return -1;
    }
}