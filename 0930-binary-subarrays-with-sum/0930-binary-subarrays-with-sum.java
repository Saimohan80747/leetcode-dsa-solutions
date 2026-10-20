class Solution {
    int sol(int[] nums,int k){
        int n=nums.length,l=0,ans=0,sum=0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l++];
            }
            ans+=(r-l+1);
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal==0) return sol(nums,goal);
        return sol(nums,goal)-sol(nums,goal-1);
    }
}