class Solution {
    public boolean checkString(String s) {
        int n=s.length();
        boolean isB=false;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                if(isB) return false;
            }else{
                isB=true;
            }
        }
        return true;
    }
}