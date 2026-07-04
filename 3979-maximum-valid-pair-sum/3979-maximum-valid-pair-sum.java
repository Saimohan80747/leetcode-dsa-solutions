class Solution {
    public int maxValidPairSum(int[] nums, int k) {
         int n=nums.length;
         int[] cum=new int[n];
        int ans=0;
         cum[n-1]=n-1;
         for(int i=n-2;i>=0;i--){
             if(nums[i]>nums[cum[i+1]]) cum[i]=i;
             else cum[i]=cum[i+1];
         }
         for(int i=0;i<n-k;i++){
             ans=Math.max(ans,nums[i]+nums[cum[i+k]]);
         }
        return ans;
    }
}