class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int rem=n%8;
        int f=(n-rem)/8;
        return (4*f+rem)*(f+1);
    }
}