// https://leetcode.com/problems/ones-and-zeroes/description/?envType=problem-list-v2&envId=50vif4uc
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[][][] dp = new int[N+1][m + 1][n + 1];
        for (int i = 1; i <= N; i++) {
            int[]zeroesOnes = countZeroesOnes(strs[i-1]);
            int zeroes = zeroesOnes[0];
            int ones = zeroesOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(zeroes <= j && ones <= k)
                        dp[i][j][k] = Math.max(dp[i][j][k], 1 + dp[i - 1][j - zeroes][k - ones]);
                }
            }
        }
        return dp[N][m][n];
    }

    int[] countZeroesOnes(String strs) {
        int[] zeroesOnes = new int[2];
        for (int i = 0; i < strs.length(); i++)
            zeroesOnes[strs.charAt(i) - '0']++;
        return zeroesOnes;
    }
}
