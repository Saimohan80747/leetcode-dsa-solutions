class Solution {
    public long shadowPairs(int[] nums) {
        long ans=0;
        Stack<int[]> st=new Stack<>();
        st.add(new int[]{nums[0],0});
        int i=1,n=nums.length,size=1;
        while(i<n){
            while(!st.isEmpty() && st.peek()[0]>nums[i]){
                size-=(st.peek()[1]+1);
                st.pop();
            }
            if(!st.isEmpty()){
                if(st.peek()[0]==nums[i]){
                    st.peek()[1]++;
                    ans+=size-st.peek()[1];
                }else{
                    ans+=size;
                    st.push(new int[]{nums[i],0});
                }
            }
            else{
                st.push(new int[]{nums[i],0});
            }
            size++;
            i++;
        }
        return ans;
    }
}