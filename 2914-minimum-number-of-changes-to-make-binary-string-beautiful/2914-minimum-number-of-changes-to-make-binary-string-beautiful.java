class Solution {
    public int minChanges(String s) {
        int ans=0;
        for(int i=0;i<s.length()-1;i+=2){
            ans+=((s.charAt(i)-'0')^(s.charAt(i+1)-'0'));
        }
        return ans;
    }
}