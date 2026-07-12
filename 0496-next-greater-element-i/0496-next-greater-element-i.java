class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length,m=nums1.length;
        int nxt_greater[]=new int[n];
        int ans[]=new int[m];
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            map.put(nums2[i],i);
            while(!st.isEmpty() && nums2[i]>=st.peek()) st.pop();
            nxt_greater[i]=(!st.isEmpty())?st.peek():-1;
            st.push(nums2[i]);
        }
        for(int i=0;i<m;i++){
           ans[i]=nxt_greater[map.get(nums1[i])];
        }
        return ans;

    }
}