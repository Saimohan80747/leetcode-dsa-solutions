class Solution {
    public int minimumDeletions(int[] nums) {
        int min_idx=0,max_idx=0;
        int n=nums.length;
        if(n<3) return n;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[max_idx]) max_idx=i;
            else if(nums[i]<nums[min_idx]) min_idx=i;
        }
        int min;
        if(min_idx<max_idx){
          min=max_idx+1;
          if(n-min_idx<min) min=n-min_idx;
          if(min_idx+1+n-max_idx<min) min=min_idx+1+n-max_idx;
        }else{
          min=min_idx+1;
          if(n-max_idx<min) min=n-max_idx;
          if(max_idx+1+n-min_idx<min) min=max_idx+1+n-min_idx;
        }
        return min;
    }
}