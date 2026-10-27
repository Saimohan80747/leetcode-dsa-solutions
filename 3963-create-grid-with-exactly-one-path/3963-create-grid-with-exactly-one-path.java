class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append('.');
        }
        ans[0]=sb.toString();
        for(int i=0;i<n-1;i++){
            sb.setCharAt(i,'#');
        }
        for(int i=1;i<m;i++){
            ans[i]=sb.toString();
        }
        return ans;
    }
}