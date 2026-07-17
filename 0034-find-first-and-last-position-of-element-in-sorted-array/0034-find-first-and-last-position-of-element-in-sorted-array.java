class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int l=0,r=n-1,mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(nums[mid]>target) r=mid-1;
            else if(nums[mid]<target) l=mid+1;
            else break;
        }
        if(l>r) return new int[]{-1,-1};
        int i=mid,j=mid;
        while(i>=0 && nums[i]==target) i--;
        while(j<n && nums[j]==target) j++;
        return new int[]{i+1,j-1};

        
    }
}