class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        char[] arr=s.toCharArray();
        int l=0,r=0,ans=2;
        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.get(arr[r])>2){
                map.put(arr[l],map.get(arr[l])-1);
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}