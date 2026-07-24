class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        int n=set.size();
        if(n<3) return n;
        ArrayList<Integer> lst=new ArrayList<>(set);
        HashSet<Integer> doublets=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                doublets.add(lst.get(i)^lst.get(j));
            }
        }
        for(int d:doublets){
            for(int num:lst){
                set.add(d^num);
            }
        }

        return set.size();
    }
}