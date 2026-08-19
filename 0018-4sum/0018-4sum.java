class Solution {
    public int n=0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        n=nums.length;
        Arrays.sort(nums);
        return ksum(nums,4,target,0);
    }
    List<List<Integer>> ksum(int[] nums,int k, long target,int idx){
        List<List<Integer>> ans=new ArrayList<>();
        if(idx>=n) return ans;
        if(k==2){
            int l=idx;
            int r=n-1;
            while(l<r){
                long sum=(long)nums[l]+nums[r];
                if(target==sum){
                    List<Integer> sub=new ArrayList<>();
                    sub.add(nums[l]);
                    sub.add(nums[r]);
                    ans.add(sub);
                    while(l<n-1 && nums[l]==nums[l+1]) l++;
                    while(r>l && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(target>sum){
                    while(l<n-1 && nums[l]==nums[l+1]) l++;
                    l++;
                }else{
                    while(r>l && nums[r]==nums[r-1]) r--;
                    r--;
                }
            }
            return ans;
        }else{
            for(int i=idx;i<n-k+1;i++){
                List<List<Integer>> sub=ksum(nums,k-1,target-nums[i],i+1);
                if(sub.size()!=0){
                    for(List<Integer> lst:sub){
                        lst.add(0,nums[i]);
                    }
                    ans.addAll(sub);
                }
                while(i<n-1 && nums[i]==nums[i+1]) i++;
            }
        }
        return ans;
    }
}