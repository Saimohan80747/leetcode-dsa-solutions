class Solution {
    public int[] asteroidCollision(int[] as) {
        int n=as.length;
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> lst=new ArrayList<>();
        st.push(as[n-1]);
        for(int i=n-2;i>=0;i--){
           if(st.isEmpty()){
               st.push(as[i]);
               continue;
           }
           if(st.peek()*as[i]>=0){
               st.push(as[i]);
           }else if(as[i]>0){
               while(!st.isEmpty() && st.peek()*as[i]<0 && as[i]>-st.peek()) st.pop();
               if(!st.isEmpty() && as[i]==-st.peek()) st.pop();
               else if(st.isEmpty() || st.peek()>0) st.push(as[i]);
            }else st.push(as[i]);
        }

        while(!st.isEmpty()){
            lst.add(st.pop());
        }
        int size=lst.size();
        int[] ans=new int[size];
        for(int i=0;i<size;i++){
            ans[i]=lst.get(i);
        }
        return ans;
    }
}