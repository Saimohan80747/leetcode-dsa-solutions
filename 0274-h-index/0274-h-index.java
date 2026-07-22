class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length,ans=0;
        int i=n-1;
        while(i>=0){
           ans++;
           if(ans==citations[i]) return ans;
           if(ans>citations[i]) return ans-1;
           i--;
        }
        return ans;
    }
}