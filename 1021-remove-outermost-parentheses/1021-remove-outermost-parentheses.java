class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length(),bal=0;
        for(int i=1;i<n;i++){

            char c=s.charAt(i);
            bal+=(c=='(')?1:-1;
            if(bal>=0){
                sb.append(c);
            }else{
                bal=0;
                i++;
            }
        }
        return sb.toString();
    }
}