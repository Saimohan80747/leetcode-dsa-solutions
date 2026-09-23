class Solution {
    int ans=Integer.MAX_VALUE;
    public void sol(int[] nums,int x){
        int n=nums.length;
        int l=0,sum=0;
        while(l<n && sum+nums[l]<=x){
            sum+=nums[l++];
        }
        l--;
        if(sum==x) ans=Math.min(ans,l+1);
        for(int r=n-1;r>l;r--){
           sum+=nums[r];
           while(l>=0 && sum>x) sum-=nums[l--];
           if(sum==x) ans=Math.min(ans,l+1+n-r);
        }
    }
    void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
    public int minOperations(int[] nums, int x) {
       
         sol(nums,x);
        //  reverse(nums);
        //  sol(nums,x);

        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}