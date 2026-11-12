class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int order=-1,len=1,ans=1,n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                if(order==0) len=2;
                else len++;
                order=1;
            }else if(nums[i]<nums[i-1]){
                if(order==1) len=2;
                else len++;
                order=0;
            }else{
                len=1;
                order=-1;
            }
            ans=Math.max(ans,len);
        }
        return ans;
    }
}