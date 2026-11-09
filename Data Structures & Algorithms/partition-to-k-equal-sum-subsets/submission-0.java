class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        boolean[] used = new boolean[nums.length];

        return helper(nums, 0, 0, target, k, used);
    }

    private boolean helper(int[] nums, int index,
                           int currentSum, int target,
                           int k, boolean[] used) {

        if (k == 1) {
            return true;
        }

        if (currentSum == target) {
            return helper(nums, 0, 0, target, k - 1, used);
        }

        for (int i = index; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (currentSum + nums[i] > target) {
                continue;
            }

            used[i] = true;

            if (helper(nums, i + 1, currentSum + nums[i],
                       target, k, used)) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }
}