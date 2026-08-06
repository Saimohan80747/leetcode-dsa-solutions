class Solution {
    public int smallestNumber(int n, int t) {
        int ans=n;
        while(true){
            int prod=1;
            int temp=ans;
            while(temp!=0){
                prod*=temp%10;
                temp/=10;
            }
            if(prod%t==0) return ans;
            ans++;
        }
    }
}