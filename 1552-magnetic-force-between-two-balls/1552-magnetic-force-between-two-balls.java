class Solution {
    boolean isPossible(int[] arr,int cnt,int m){
        int balls=1,idx=0,n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]-arr[idx]>=cnt){
                balls++;
                idx=i;
            }
            if(balls==m) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length,l=1,r=position[n-1]-position[0];
        while(l<=r){
            int mid=(l+r)/2;
            if(isPossible(position,mid,m)){
                l=mid+1;
            }else r=mid-1;
        }
        return r;
    }
}