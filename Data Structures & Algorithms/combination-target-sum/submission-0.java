class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(nums , 0,target , result , current);
        return result;
    }

    void helper(int []nums,int index ,int target,List<List<Integer>> result ,List<Integer> current){
        if(target ==0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0){
            return;
        }
        
        if(index  == nums.length){
            return ;
        }

        current.add(nums[index]);
        helper(nums , index , target -nums[index] , result , current);
        current.remove(current.size()-1);
        helper(nums , index +1 , target , result , current);
    }
}
