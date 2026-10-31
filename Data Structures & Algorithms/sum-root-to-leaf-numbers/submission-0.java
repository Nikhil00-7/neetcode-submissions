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
    public int sumNumbers(TreeNode root) {
    
    return helper(root , 0);
    }

    int helper(TreeNode root , int currentNode){
        if(root == null){
            return 0;
        }

        currentNode = currentNode  * 10 + root.val;

        if(root.left == null && root.right == null){
            return currentNode;
        }

        int left =helper(root.left , currentNode);
        int right = helper(root.right , currentNode);

        return left + right;
    }
}