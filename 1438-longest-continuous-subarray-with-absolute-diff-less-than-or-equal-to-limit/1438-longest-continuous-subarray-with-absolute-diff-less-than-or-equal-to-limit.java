class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, ans = 1,l=0;

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> max_heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int r = 0; r < n; r++) {
            min_heap.add(new int[]{nums[r], r});
            max_heap.add(new int[]{nums[r], r});
            while(max_heap.peek()[0]-min_heap.peek()[0]>limit){
                l++;
                while(!min_heap.isEmpty() && min_heap.peek()[1]<l) min_heap.poll();
                while(!max_heap.isEmpty() && max_heap.peek()[1]<l) max_heap.poll();
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;

    }
}