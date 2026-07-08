// https://leetcode.com/problems/house-robber-ii/description/?envType=problem-list-v2&envId=50vif4uc
class Solution {

    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];

        int dp1[]= new int[nums.length+1];
        Arrays.fill(dp1, -1);

        int dp2[]= new int[nums.length+1];
        Arrays.fill(dp2, -1);

        return Math.max(
                helper(nums, 0, nums.length - 2, dp1),
                helper(nums, 1, nums.length - 1, dp2)
        );
    }

    int helper(int[] nums, int i, int end, int[] dp) {

        if (i > end)
            return 0;
        
        if (dp[i] != -1)
            return dp[i];

        int rob = nums[i] + helper(nums, i + 2, end, dp);

        int skip = helper(nums, i + 1, end, dp);

        return dp[i] = Math.max(rob, skip);
    }
}
