class Solution {
    public int minimumPushes(String word) {
        Integer freq[]=new Integer[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = 0;
        }
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq,(a,b)->b-a);
        int f;
        int i=0;
        int ans=0;
        while(i<26 && freq[i]!=0){
            f=1+(i-i%8)/8;
            ans+=freq[i]*f;
            i++;
        }
        return ans;
    }
}