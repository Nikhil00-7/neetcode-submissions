class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<List<Integer>>  result  = new ArrayList<>();
         List<Integer> list = new ArrayList<>();

         helper(nums , target , 0 , result , list);

         return result;    
    }


    void helper(int []nums ,int target ,int start  , List<List<Integer>> result , List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        if(target < 0){
            return;
        }

        if( start == nums.length){
            return;
        }

        list.add(nums[start]);

        helper(nums , target - nums[start] , start , result , list);
        list.remove(list.size()-1);
        helper(nums , target , start+1 , result , list);
    }
}
