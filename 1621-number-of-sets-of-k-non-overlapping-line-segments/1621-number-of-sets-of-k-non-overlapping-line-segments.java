class Solution {
    public int numberOfSets(int n, int k) {
        if(k==n-1) return 1;
        int[][] dp=new int[k+1][n+1];
        int MOD=1000000007;
        dp[1][2]=1;
        int sum=2;
        for(int i=3;i<=n;i++){
            dp[1][i]=(dp[1][i-1]+sum)%MOD;
            sum++;
        }
        
        for(int i=2;i<=k;i++){
            for(int j=i+1;j<=n;j++){
                dp[i-1][j]=(dp[i-1][j]+dp[i-1][j-1])%MOD;
            }
            for(int j=i+1;j<=n;j++){
                dp[i][j]=(dp[i-1][j-1]+dp[i][j-1])%MOD;
            }
        }
        return dp[k][n];


    }
}