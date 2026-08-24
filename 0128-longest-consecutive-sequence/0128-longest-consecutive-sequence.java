
class Solution {
  
    
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int ans=0;
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int num:nums) map.put(num,false);
        for(int i=0;i<n;i++){
           if(!map.containsKey(nums[i]-1) && !map.get(nums[i])){
              map.put(nums[i],true);
              int num=nums[i]+1,cnt=1;
              while(map.containsKey(num)){
                  cnt++;
                  num++;
              }
              ans=Math.max(ans,cnt);
           }
        }
        return ans;
    }
}
