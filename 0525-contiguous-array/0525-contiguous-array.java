class Solution {
    public int findMaxLength(int[] nums) {
        int ans=0,n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++){
           if(nums[i]==0) sum--;
           else sum++;
           if(map.containsKey(sum)){
              ans=Math.max(ans,i-map.get(sum));
           }else{
              map.put(sum,i);
           }
        }
        return ans;
    }
}