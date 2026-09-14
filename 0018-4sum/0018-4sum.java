class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            for(int j=i+3;j<n;j++){
                while(j<n-1 && nums[j]==nums[j+1]) j++;
                long sub_target=(long)target-nums[i]-nums[j];
                int l=i+1,r=j-1;
                while(l<r){
                    int sum=nums[l]+nums[r];
                    if(sum==sub_target){
                        List<Integer> sub=new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[l]);
                        sub.add(nums[r]);
                        sub.add(nums[j]);
                        ans.add(sub);
                        while(l<n-1 && nums[l]==nums[l+1]) l++;
                        while(r>0 && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(sum>sub_target){
                        while(r>0 && nums[r]==nums[r-1]) r--;
                        r--;
                    }else{
                        while(l<n-1 && nums[l]==nums[l+1]) l++;
                        l++;
                    }
                }
                
            }
            while(i<n-3 && nums[i]==nums[i+1]) i++;
        }
        return ans;
    }
   
}