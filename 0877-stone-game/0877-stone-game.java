class Solution {
    int dp(int i,int j,int k,int[] nums,int[][][] memo){
       if(i==j){
         if(k==0) return nums[i];
         return 0;
       }
       if(memo[i][j][k]!=-1) return memo[i][j][k];
       if(k==0) return memo[i][j][k]=Math.max(dp(i+1,j,1,nums,memo)+nums[i],dp(i,j-1,1,nums,memo)+nums[j]);
       return memo[i][j][k]=Math.min(dp(i+1,j,0,nums,memo),dp(i,j-1,0,nums,memo));

    }
    public boolean stoneGame(int[] piles){
        int n=piles.length,total_score=0;
        for(int num:piles) total_score+=num;
        int[][][] memo=new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                memo[i][j][0]=-1;
                memo[i][j][1]=-1;
            }
        }
        int alice_score=dp(0,n-1,0,piles,memo);
        int bob_score=total_score-alice_score;
        if(alice_score>=bob_score) return true;
        return false;
    }
}