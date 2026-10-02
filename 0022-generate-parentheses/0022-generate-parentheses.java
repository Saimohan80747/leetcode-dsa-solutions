class Solution {
    void func(List<String> ans,String s,int lp,int rp,int sum){
            if(lp==0 && rp==0){
                ans.add(s);
                return;
            }
            if(lp!=0) func(ans,s+"(",lp-1,rp,sum+1);
            if(rp!=0 && sum!=0) func(ans,s+")",lp,rp-1,sum-1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        func(ans,"(",n-1,n,1);
        return ans;
    }
}