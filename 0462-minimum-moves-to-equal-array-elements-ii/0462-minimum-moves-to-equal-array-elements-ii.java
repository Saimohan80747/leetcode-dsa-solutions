class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length,ans=0;
        Arrays.sort(nums);
        int mid=n/2;
        for(int num:nums) ans+=Math.abs(num-nums[mid]);
        return ans;
    }
}