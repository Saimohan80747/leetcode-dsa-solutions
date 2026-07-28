class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int mid=n/2;
        int[] freq=new int[26];
        for(int i=0;i<mid;i++){
            char c=s.charAt(i);
            freq[c-'a']++;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i];j++) sb.append((char)('a'+i));
        }
        if(n%2!=0) sb.append(s.charAt(mid));
        for(int i=25;i>=0;i--){
            for(int j=0;j<freq[i];j++) sb.append((char)('a'+i));
        }
        return sb.toString();
    }
}