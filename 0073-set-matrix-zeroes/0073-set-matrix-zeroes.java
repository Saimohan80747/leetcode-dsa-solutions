class Solution {
    public void fun(int[][] m,boolean[][] b,int x,int y){
        int n=m.length;
        int m1=m[0].length;
           for(int i=0;i<n;i++){
            
            if(m[i][y]!=0){
              m[i][y]=0;
              b[i][y]=true;
            }
            }
           
           for(int i=0;i<m1;i++){
            if(m[x][i]!=0){
              m[x][i]=0;
              b[x][i]=true;
            }
           }
    }
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean[][] b=new boolean[n][m];
        int i=0;
        while(i<n){
            int j=0;
            while(j<m){
                if(matrix[i][j]==0 && !b[i][j]){
                    fun(matrix,b,i,j);
                }
                j++;
            }
            i++;
        }

    }
}