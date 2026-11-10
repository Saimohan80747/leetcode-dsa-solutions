class Solution {
    int dp(int i,int[] costs,int[] memo,int n){
        if(i==n) return 0;
        if(i>n) return Integer.MAX_VALUE;
        if(memo[i]!=0) return memo[i];
        int c1=dp(i+1,costs,memo,n);
        int c2=dp(i+2,costs,memo,n);
        int c3=dp(i+3,costs,memo,n);
        if(c1!=Integer.MAX_VALUE) c1+=costs[i+1]+1;
        if(c2!=Integer.MAX_VALUE) c2+=costs[i+2]+4;
        if(c3!=Integer.MAX_VALUE) c3+=costs[i+3]+9;
        return memo[i]=Math.min(c1,Math.min(c2,c3));
    }
    public int climbStairs(int n, int[] costs) {
        int[] memo=new int[n+1];
        int[] arr=new int[n+1];
        for(int i=0;i<n;i++){
            arr[i+1]=costs[i];
        }
        return dp(0,arr,memo,n);
        
    }
}