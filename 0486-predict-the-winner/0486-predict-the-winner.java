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
    public boolean predictTheWinner(int[] nums){
        int n=nums.length,total_score=0;
        for(int num:nums) total_score+=num;
        int[][][] memo=new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                memo[i][j][0]=-1;
                memo[i][j][1]=-1;
            }
        }
        int p1_score=dp(0,n-1,0,nums,memo);
        System.out.println(p1_score);
        int p2_score=total_score-p1_score;
        if(p1_score>=p2_score) return true;
        return false;
    }
}