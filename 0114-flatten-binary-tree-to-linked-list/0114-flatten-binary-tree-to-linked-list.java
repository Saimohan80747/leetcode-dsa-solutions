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
    
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        boolean lleaf=(root.left!=null && root.left.left==null && root.left.right==null);
        boolean rleaf= (root.right!=null && root.right.left==null && root.right.right==null);
        if((lleaf && rleaf) || (lleaf && root.right==null)){
             TreeNode r=root.right;
             root.right=root.left;
             root.right.right=r;
             root.left=null;
             return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode r=root.right;
        root.right=root.left;
        TreeNode temp=root;
        while(temp.right!=null) temp=temp.right;
        temp.right=r;
        root.left=null;
    }
}