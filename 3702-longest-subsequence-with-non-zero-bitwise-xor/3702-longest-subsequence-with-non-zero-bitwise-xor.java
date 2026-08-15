class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int txor=0;
        boolean isXero=true;
        for(int num:nums){
            if(isXero && num!=0) isXero=false;
            txor^=num;
        }
        if(txor!=0) return n;
        if(isXero) return 0;
        return n-1;
    }
}