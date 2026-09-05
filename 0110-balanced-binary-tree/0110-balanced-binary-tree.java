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
    public int height( TreeNode root ){
        if(root==null ||(root.left==null && root.right==null)) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        
        if(root==null) return true;
        boolean b=isBalanced(root.left) && isBalanced(root.right);
        if(b==false){return false;}
      
        
          int l=height(root.left);
          if(root.left!=null){l++;}
        int r=height(root.right);
          if(root.right!=null){r++;}

        if(l>=r){
            if(l-r>1){return false;}
            else{return true;}
        }
        else{
            if(r-l>1){return false;}
            else{return true;}
        }
       
    }
}