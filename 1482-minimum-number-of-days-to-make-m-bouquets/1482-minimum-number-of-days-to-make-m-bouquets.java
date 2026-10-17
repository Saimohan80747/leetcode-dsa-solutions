class Solution {
    int getBouques(int day,int[] arr,int k){
        int ans=0,cnt=0,n=arr.length;
        for(int i=0;i<n;i++){

            if(arr[i]<=day){
                cnt++;
                if(cnt==k){
                    ans++;
                    cnt=0;
                }
            }else cnt=0;
        }
        return ans;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length,i=0;
        HashSet<Integer> set=new HashSet<>();
        for(int num:bloomDay) set.add(num);
        int[] nums=new int[set.size()];
        for(int num:set) nums[i++]=num;
        Arrays.sort(nums);
        int l=0,r=nums.length-1,ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            int boq=getBouques(nums[mid],bloomDay,k);
            if(boq>=m){
                ans=nums[mid];
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}