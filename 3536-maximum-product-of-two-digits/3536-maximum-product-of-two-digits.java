class Solution {
    public int maxProduct(int n) {
        int f_max=0,s_max=0;
        while(n!=0){
           int d=n%10;
           if(f_max<d){
              s_max=f_max;
              f_max=d;
           }else if(s_max<d){
              s_max=d;
           }
           n/=10;
        }
        return f_max*s_max;
    }
}