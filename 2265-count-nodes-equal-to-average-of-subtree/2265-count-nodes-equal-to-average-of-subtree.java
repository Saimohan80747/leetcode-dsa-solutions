/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int[] dfs(TreeNode root){
        if(root==null) return new int[]{0,0};
        
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int sum=root.val+left[0]+right[0];
        int n=left[1]+right[1]+1;
        if(Math.round(sum/n)==root.val) ans++;
        return new int[]{sum,n};
    }
    public int averageOfSubtree(TreeNode root) {
        
        dfs(root);
        return ans;        
    }
}