class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list =new ArrayList<>();

        helper(nums , 0 , result , list);

        return result;   
    }
    static void helper(int []nums , int index ,List<List<Integer>> result ,List<Integer> list){
        if(index  == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
      
      helper(nums, index +1 , result , list);
      list.add(nums[index]);
      helper(nums, index +1 , result , list);

      list.remove(list.size()-1);
    
    }
}
