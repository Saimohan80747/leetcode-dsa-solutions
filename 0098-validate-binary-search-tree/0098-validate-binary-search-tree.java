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
    
    public void fun(ArrayList<Integer> arr,TreeNode root){
        if(root==null) return;
       
        fun(arr,root.left);
        arr.add(root.val);
        fun(arr,root.right);

        return;
    }
    public boolean isSorted(ArrayList<Integer> list) {
    for (int i = 1; i < list.size(); i++) {
        if (list.get(i) <= list.get(i - 1)) {
            return false;
        }
    }
    return true;
}

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
       fun(arr,root);
       if(arr.size()==1) return true;
       if(arr.size()==0) return false;
       return isSorted(arr);
    }
}