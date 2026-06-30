//https://leetcode.com/problems/target-sum/description/?envType=problem-list-v2&envId=50vif4uc
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum+= nums[i];

        if(sum < target)    
            return 0;
        
        if( (sum + Math.abs(target)) % 2 != 0 )
            return 0;

        int targetSum = ( sum + Math.abs(target) ) / 2;
        return countSubsetSum(nums.length, targetSum, nums);
    }

    int countSubsetSum(int n, int sum, int[]nums){
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i-1] <= j)
                     dp[i][j] += dp[i-1][j-nums[i-1]];
             }
        }
        return dp[n][sum];
    }
}
