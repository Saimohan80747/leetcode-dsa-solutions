class Solution {
    HashSet<List<Integer>> set=new HashSet<>();
    void permute(ArrayList<Integer> lst,StringBuilder s,int[] nums,int idx){
        lst.add(nums[s.charAt(idx)-'0']);
        if(s.length()==1){
            set.add(new ArrayList<>(lst));
            return;
        }
        StringBuilder temp = new StringBuilder(s);
        temp.deleteCharAt(idx);
        for(int i=0;i<temp.length();i++){
            permute(lst,temp,nums,i);
            lst.remove(lst.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        StringBuilder s=new StringBuilder();
        int n=nums.length;
        for(int i=0;i<n;i++) s.append(i);
        for(int i=0;i<n;i++){
            permute(new ArrayList<>(),s,nums,i);
        }
        return new ArrayList<>(set);
    }
}