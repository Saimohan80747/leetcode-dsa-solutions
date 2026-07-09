class Solution {
    
    
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD=1_000_000_007; 
        final int MAX=100001;
        int n=s.length();
        int[] pow=new int[MAX];
        int[] sum=new int[n+1];
        int[] num=new int[n+1];
        int[] len=new int[n+1];
        pow[0]=1;
        for(int i=1;i<MAX;i++){
            pow[i] = (int)((pow[i - 1] * 10L) % MOD);
        }
        for(int i=1;i<=n;i++){
            int d=s.charAt(i-1)-'0';
            sum[i]=sum[i-1]+d;
            len[i]=(d==0)?len[i-1]:len[i-1]+1;
            num[i]=(d==0)?num[i-1]:(int)((num[i-1]*10L+d)%MOD);
        }
        // for(int i=0;i<=n;i++){
        //     System.out.print(sum[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<=n;i++){
        //     System.out.print(num[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<=n;i++){
        //     System.out.print(len[i]+" ");
        // }
        int[] ans=new int[queries.length];
        for(int idx=0;idx<queries.length;idx++){
            int i=queries[idx][0];
            int j=queries[idx][1];
            int a=sum[j+1]-sum[i];
            int x=(num[j+1]-(int)(1L*num[i]*pow[len[j+1]-len[i]] % MOD)+MOD)%MOD;
            ans[idx]=(int)((1L*x*a)% MOD);
        }
        return ans;


    }
}