class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int n = nums.length;
       int currMax = nums[0];
       int maxSum = nums[0];

       int currMin = nums[0];
       int minSum = nums[0];

       int total= nums[0];

       for(int i =1 ; i< n;i++){
        int num = nums[i];

        currMax = Math.max(num , currMax + num);
        maxSum = Math.max(maxSum , currMax);

        currMin = Math.min(num , currMin + num);
        minSum = Math.min(minSum , currMin);

        total += num;    

       } 
        if(maxSum < 0){
            return maxSum;
        }  


        return Math.max(maxSum , total - minSum);
    }
}