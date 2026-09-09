class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0;
        long c1_sum=1000000L-1000L;
        long c2_sum=c1_sum+2L*(1000000000L-1000000L);
        long c3_sum=c2_sum+3L*(1000000000000L-1000000000L);
        long c4_sum=c3_sum+4L*(1000000000000000L-1000000000000L);
        if(n>=1000L && n<1000000L){
            return n-999L; 
        }else if(n>=1000000L && n<1000000000L){
            return c1_sum+2L*(n-999999L);
        }else if(n>=1000000000L && n<1000000000000L){
            return c2_sum+3L*(n-999999999L);
        }else if(n>=1000000000000L && n<1000000000000000L){
            return c3_sum+4L*(n-999999999999L);
        }else{
            return c4_sum+5L;
        }
    }
}