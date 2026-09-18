class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans=0;
        int n=nums1.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(nums3[i]+nums4[j],map.getOrDefault(nums3[i]+nums4[j],0)+1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans+=map.getOrDefault(-nums1[i]-nums2[j],0);
            }
        }
        return ans;
    }
}