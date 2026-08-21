
class Solution {

   
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        
        int i=0;
        while(i<n-2 && nums[i]<=0){
            if(i>0 && nums[i]==nums[i-1]){
                i++;
                continue;
            }
            int l=i+1;
            int r=n-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                   List<Integer> lst=new ArrayList<>();
                   lst.add(nums[i]);
                   lst.add(nums[l]);
                   lst.add(nums[r]);
                   ans.add(lst);
                   while(l<r && nums[l]==nums[l+1]) l++;
                   while(l<r && nums[r]==nums[r-1]) r--;
                   l++;
                   r--;
                }else if(sum>0) r--;
                else l++;
            }
            i++;
        }
        return ans;
    }
}