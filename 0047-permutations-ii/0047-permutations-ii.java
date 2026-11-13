class Solution {
    HashSet<List<Integer>> set=new HashSet<>();
    void permute(ArrayList<Integer> lst,String s,int[] nums,int idx){
        lst.add(nums[s.charAt(idx)-'0']);
        if(s.length()==1){
            set.add(new ArrayList<>(lst));
            return;
        }
        String str=s.substring(0,idx)+s.substring(idx+1);
        for(int i=0;i<str.length();i++){
            permute(lst,str,nums,i);
            lst.remove(lst.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        String s="";
        int n=nums.length;
        for(int i=0;i<n;i++) s+=i;
        for(int i=0;i<n;i++){
            permute(new ArrayList<>(),s,nums,i);
        }
        return new ArrayList<>(set);
    }
}