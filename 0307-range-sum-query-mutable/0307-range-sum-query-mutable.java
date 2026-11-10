class SegmentTree{
    int[] arr;
    int[] seg;
    int n;
    SegmentTree(int[] input){
        n=input.length;
        arr=input;
        seg=new int[4*n];
        build(0,0,n-1);
    }
    void build(int idx,int l,int r){
        if(l==r){
            seg[idx]=arr[l];
            return;
        }
        int mid=(l+r)>>1;
        build(2*idx+1,l,mid);
        build(2*idx+2,mid+1,r);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    void pointUpdate(int idx,int l,int r,int up,int val){
        if(l==r){
            seg[idx]=val;
            return;
        }
        if(up<l || up>r) return;
        int mid=(l+r)>>1;
        if(l<=up && up<=mid){
            pointUpdate(2*idx+1,l,mid,up,val);
        }else{
            pointUpdate(2*idx+2,mid+1,r,up,val);
        }
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    int queryRange(int idx,int low,int high,int l,int r){
        if(low>r || high<l) return 0;
        if(low>=l && high<=r) return seg[idx];
        int mid=(low+high)>>1;
        return queryRange(2*idx+1,low,mid,l,r)+queryRange(2*idx+2,mid+1,high,l,r);
    }
}

class NumArray {
    SegmentTree st;
    public NumArray(int[] nums) {
        st=new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        st.pointUpdate(0,0,st.n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return st.queryRange(0,0,st.n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */