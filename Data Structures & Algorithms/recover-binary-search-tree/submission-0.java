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
    List<TreeNode> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        inorder(root);

         TreeNode first = null;
         TreeNode second = null;
        for(int i =0; i< list.size()-1 ; i++){
            if(list.get(i).val > list.get(i+1).val){
                if(first == null){
                    first = list.get(i);
                }

                second = list.get(i+1);
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val  = temp;
    }
    void inorder(TreeNode node){
        if(node  == null){
            return;
        }

        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }
}