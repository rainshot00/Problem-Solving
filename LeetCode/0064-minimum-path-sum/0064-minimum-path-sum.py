class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        dp[0][0] = grid[0][0]

        for i in range(1, m):
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        for k in range(1, n):
            dp[0][k] = dp[0][k - 1] + grid[0][k]

        for i in range(1, m):
            for k in range(1, n):
                dp[i][k] = min(dp[i - 1][k], dp[i][k - 1]) + grid[i][k]

        return dp[-1][-1]