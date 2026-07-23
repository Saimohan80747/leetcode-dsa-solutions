class Solution {
    int bit_len(int n){
        int len=0;
        while(n!=0){
            len++;
            n>>=1;
        }
        return len;
    }
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<3) return n;
        int len=bit_len(n);
        return (1<<len);

    }
}