class NumArray {
   
    Node root;
    public NumArray(int[] nums) {
        this.root = constructTree(nums , 0 , nums.length-1);
    }
    Node constructTree(int []nums , int start ,int end){
      if(start == end){
        Node leaf = new Node(start ,end);
        leaf.data = nums[start];
        return leaf;
      }

      Node node = new Node(start ,end);
      int mid = (start + end)/2;

      node.left = constructTree(nums, start , mid);
      node.right = constructTree(nums, mid+1 , end);

      node.data = node.left.data + node.right.data;
      
      return node;
    }  

    public int sumRange(int left, int right) {
       return sumRange(this.root , left , right);       
    }

    public int sumRange(Node node ,int left ,int right){
       
       if(node.endInterval < left || node.startInterval > right){
        return 0;
       }

       if(node.startInterval >= left && node.endInterval <= right){
        return node.data;
       }

       return sumRange(node.left, left , right) + sumRange(node.right , left , right);

    }
    class Node {
        int data;
        Node left;
        Node right;
        int startInterval;
        int endInterval;

        Node(int startInterval , int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */