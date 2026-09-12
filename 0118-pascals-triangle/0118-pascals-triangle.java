class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascals_triangle=new ArrayList<>();
        List<Integer> prev=new ArrayList<>();
        prev.add(1);
        pascals_triangle.add(prev);
        for(int i=2;i<=numRows;i++){
            List<Integer> curr=new ArrayList<>();
            curr.add(1);
            int prev_num=1,j=1;
            while(j<prev.size()){
                int curr_num=prev.get(j);
                curr.add(prev_num+curr_num);
                prev_num=curr_num;
                j++;
            }
            curr.add(1);
            pascals_triangle.add(curr);
            prev=curr;
        }
        return pascals_triangle;

    }
}