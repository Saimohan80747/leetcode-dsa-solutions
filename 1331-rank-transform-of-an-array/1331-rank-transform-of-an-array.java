class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] dum=new int[n];
        for(int i=0;i<n;i++){
           dum[i]=arr[i];
        }
        Arrays.sort(dum);
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int a:dum){
            if(!map.containsKey(a)){
                map.put(a,++cnt);
            }
        }
        for(int i=0;i<n;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}