class Solution {
    public int[] reverse(int[] nums,int l,int r){
            while(l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++; r--;
            }
            return nums;
    }
    public void swap(int[] nums,int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1) return;
        int i=n-1;
        while(i>0 && nums[i]<=nums[i-1]) i--;
        if(i==0) reverse(nums,0,n-1);
        else if(i==n-1) swap(nums,i,i-1);
        else {
            int j=n-1;
            while(nums[j]<=nums[i-1]) j--;
            swap(nums,i-1,j);
            reverse(nums,i,n-1);
        }
    }
}