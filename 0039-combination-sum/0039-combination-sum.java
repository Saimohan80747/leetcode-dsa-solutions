class Solution {
    public void fun( List<List<Integer>> ans,ArrayList<Integer> sub,int sum,int a,int[] arr,int t){
        
        if(sum>t){
            return;
        }
        if(sum==t){
            ans.add(new ArrayList<>(sub));
            return;
        }
        int n=arr.length;
        for(int i=a;i<n;i++){
           
            sub.add(arr[i]);
            fun(ans,sub,sum+arr[i],i,arr,t);
           
            sub.remove(sub.size()-1);

        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;
        List<List<Integer>> ans=new ArrayList<>();
        fun(ans,new ArrayList<>(),0,0,candidates,target);
        

        return ans;
    }
}