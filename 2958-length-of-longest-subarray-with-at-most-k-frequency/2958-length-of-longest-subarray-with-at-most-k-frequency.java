class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length,ans=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0,r=0;
        while(r<n){
           int freq=map.getOrDefault(nums[r],0);
           if(freq<k){
              map.put(nums[r],freq+1);
           }else{
               ans=Math.max(ans,r-l);
               while(nums[l]!=nums[r]){
                map.put(nums[l],map.get(nums[l])-1);
                l++;
               }
               l++;
           }
           r++;
        }
        return Math.max(ans,r-l);
    }
}