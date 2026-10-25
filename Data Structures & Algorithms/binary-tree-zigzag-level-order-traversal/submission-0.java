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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i= 0; i< size; i++){

                if(leftToRight){
                  TreeNode currentNode = queue.pollFirst();
                  currentLevel.add(currentNode.val);

                  if(currentNode.left != null){
                    queue.offerLast(currentNode.left);
                  }
                  if(currentNode.right != null){
                    queue.offerLast(currentNode.right);
                  }
                }

                if(!leftToRight){
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);

                    if(currentNode.right != null){
                        queue.offerFirst(currentNode.right);
                    }

                    if(currentNode.left != null){
                        queue.offerFirst(currentNode.left);
                    }
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
}