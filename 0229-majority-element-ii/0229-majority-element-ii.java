class Solution {
    public List<Integer> majorityElement(int[] nums) {
      
       List<Integer> ans=new ArrayList<>();
       int n=nums.length;
       int num1=-1,num2=-1,cnt1=0,cnt2=0;
       for(int i=0;i<n;i++){
          if(cnt1==0 && nums[i]!=num2){
            num1=nums[i];
          }else if(cnt2==0){
            num2=nums[i];
          }
          if(num1==nums[i]){
             cnt1++;
          }else if(num2==nums[i]){
             cnt2++;
          }else{
            cnt1--;
            cnt2--;
          }
       }
       cnt1=0;
       cnt2=0;
       for(int num:nums){
          if(num==num1) cnt1++;
          else if(num==num2) cnt2++;
       }
       if(cnt1>(n/3)) ans.add(num1);
       if(cnt2>(n/3)) ans.add(num2);
       return ans;
    }
}