class Solution {
    List<String> ans;
    void solve(long[] arr,long t,StringBuilder sb,int idx,long prev,long curr,long accCurr,char accPrevOper,char prevOper,long num){
        if(idx>arr.length) return;
        if(idx==arr.length){
            if(num==t) ans.add(sb.toString());
            return;
        }
        sb.append('+');
        sb.append(arr[idx]);
        solve(arr,t,sb,idx+1,num,arr[idx],arr[idx],'+','+',num+arr[idx]);
        sb.setCharAt(sb.length()-2,'-');
        solve(arr,t,sb,idx+1,num,arr[idx],arr[idx],'-','-',num-arr[idx]);
        sb.setCharAt(sb.length()-2,'*');
        long a=0;
        if(prevOper=='+') a=prev+(curr*arr[idx]);
        else if(prevOper=='-') a=prev-(curr*arr[idx]);
        else a=num*arr[idx]; 
        solve(arr,t,sb,idx+1,prev,curr*arr[idx],arr[idx],'*',prevOper,a);
        sb.deleteCharAt(sb.length()-2);
        if(accCurr!=0){
            if(prevOper=='+') a = prev +(curr/accCurr)*(accCurr*10 + arr[idx]);
            else if(prevOper=='-') a=prev-(curr/accCurr)*(accCurr*10 + arr[idx]);
            else if(accPrevOper=='*') a=(curr/accCurr)*(accCurr*10 + arr[idx]);
            else a=num*10+arr[idx];
            solve(arr,t,sb,idx+1,prev,(curr/accCurr)*(accCurr*10 + arr[idx]),accCurr*10 + arr[idx],'*',prevOper,a);
        }
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> addOperators(String num, int target) {
        ans=new ArrayList<>();
        char[] numChar=num.toCharArray();
        int n=numChar.length;
        long[] numInt=new long[n];
        for(int i=0;i<n;i++){
            numInt[i]=numChar[i]-'0';
        }
        solve(numInt,target,new StringBuilder().append(numInt[0]),1,0,numInt[0],numInt[0],'#','#',numInt[0]);
        return ans;
    }
}