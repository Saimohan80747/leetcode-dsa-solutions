class Solution {
    public int removeCoveredIntervals(int[][] in) {
        int n=in.length;
        Arrays.sort(in,(a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });
        int idx=0,cov=0;
        for(int i=1;i<n;i++){
           if(in[i][0]<=in[idx][1]){
                if(in[i][1]>in[idx][1]) idx=i;
                else cov++;
           }else{
               idx=i;
           }
        }
        return n-cov;
    }
}