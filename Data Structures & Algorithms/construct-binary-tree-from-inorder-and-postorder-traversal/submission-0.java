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
    HashMap<Integer , Integer> map = new HashMap<>();
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

    for(int i =0 ; i < inorder.length ; i++){
        map.put(inorder[i] , i);
    }    

    index = postorder.length-1;

    return helper(postorder , 0 , postorder.length-1);
    }

    TreeNode helper(int []postorder ,int left , int right){
        if(left > right){
            return null;
        }
        
        int rootValue = postorder[index--];
        TreeNode node = new TreeNode(rootValue);
        int mid = map.get(rootValue);

        node.right = helper(postorder , mid+1 , right);
        node.left = helper(postorder , left, mid-1);
        
        return node;

    }
}