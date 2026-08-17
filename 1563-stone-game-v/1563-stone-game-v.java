class Solution {
    public int dp(int l,int r,int[] pref,int[][] memo){
        if(memo[l][r]!=-1) return memo[l][r];
        int max=0;
        for(int m=l;m<r;m++){
           int lsum=(l==0)?pref[m]:pref[m]-pref[l-1];
           int rsum=pref[r]-pref[m];
           int sum;
           if(lsum>rsum){
             sum=rsum+dp(m+1,r,pref,memo);
           }else if(rsum>lsum){
             sum=lsum+dp(l,m,pref,memo);
           }else{
             sum=rsum+Math.max(dp(m+1,r,pref,memo),dp(l,m,pref,memo));
           }
           max=Math.max(max,sum);
        }
        return memo[l][r]=max;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[] pref=new int[n];
        int[][] memo=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        pref[0]=stoneValue[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+stoneValue[i];
        }
        return dp(0,n-1,pref,memo);
    }
}