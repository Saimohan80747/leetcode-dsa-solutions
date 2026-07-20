class Solution {
    
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        k=k%(m*n);
        int idx=1;
        int i=m-1,j=n-1;
        boolean isFound=false;
        while(i>=0){
            j=n-1;
            while(j>=0){
               if(k==idx || k==0){
                   isFound=true;
                   break;
               }
               idx++;
               j--;
            }
            if(isFound) break;
            i--;
        }

        int ni,nj;
        if(k==0){
            ni=0;
            nj=0;
        }else{
            ni=i;
            nj=j;
        }
        
        i=0;
        List<List<Integer>> ans=new ArrayList<>();
        while(i<m){
            j=0;
            List<Integer> lst=new ArrayList<>();
            while(j<n){

                lst.add(grid[ni][nj]);
                if(nj==n-1){
                    nj=0;
                    if(ni==m-1) ni=0;
                    else ni++;
                }else{
                    nj++;
                }
                j++;
            }
            ans.add(lst);
            i++;
        }
        return ans;

    }
}