class Solution {
    HashSet<List<Integer>> ans=new HashSet<>();
    public void purmutation(int[] nums,ArrayList<Integer> a,boolean[] bool){
         if(a.size()==nums.length){
            ans.add(new ArrayList<>(a));
            return;
         }
          
        for(int j=0;j<nums.length;j++){
                if(bool[j]) continue;
                a.add(nums[j]);
                bool[j]=true;
                purmutation(nums,a,bool);
                bool[j]=false;
                a.remove(a.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> a=new ArrayList<>();
        boolean bool[]= new boolean[n]; 
        purmutation(nums,a,bool);  
        return new ArrayList<>(ans);
    }
}