class Solution {
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public long gcdSum(int[] nums) {
        long ans=0;
        int n=nums.length;
        int[] pref=new int[n];
        int max=-1;
        for(int i=0;i<n;i++){
           max=Math.max(max,nums[i]);
           pref[i]=gcd(max,nums[i]);
        }
       
        Arrays.sort(pref);
        for(int i=0;i<n/2;i++){
            ans+=gcd(pref[i],pref[n-i-1]);
        }
        return ans;
    }
}