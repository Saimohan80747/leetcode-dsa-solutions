class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0) nums[i]=-nums[i];
        }
        Arrays.sort(nums);
        for(int i=n-1;i>=n/2;i--){
            ans+=(long)nums[i]*nums[i];
        }
        for(int i=n/2 -1;i>=0;i--){
            ans-=(long)nums[i]*nums[i];
        }
        return ans;

    }
}