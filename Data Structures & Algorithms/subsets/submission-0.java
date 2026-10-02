class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, nums, result , current);

        return result;
    }

    void solve (int index ,int []arr ,List<List<Integer>> result , List<Integer> current){
        if(index == arr.length){
            result.add(new ArrayList<>(current));
            return;
        }

        solve(index +1 , arr , result , current);

        current.add(arr[index]);
        solve(index +1 , arr ,result , current);

        current.remove(current.size()-1);
    }
}
