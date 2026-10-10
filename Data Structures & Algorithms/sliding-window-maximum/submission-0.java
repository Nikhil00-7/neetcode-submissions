class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      int []result = new int [n - k+1];
      int index = 0;
      Deque<Integer> queue = new ArrayDeque<>();
      for(int i =0; i<n;i++){

        while(!queue.isEmpty() && queue.peekFirst() <= i-k){
            queue.removeFirst();
        }

        while(!queue.isEmpty() && nums[queue.peekLast()]<= nums[i]){
            queue.removeLast();
        }

        queue.add(i);

        if(i >= k-1){
            result[index++] = nums[queue.peekFirst()];
        }
      }   
      return result;
    }
}
