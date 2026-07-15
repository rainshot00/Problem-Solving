class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]

        for i in range(m):
            dp[i][0] = 1
        for k in range(n):
            dp[0][k] = 1
        
        for i in range(1, m):
            for k in range(1, n):
                dp[i][k] = dp[i - 1][k] + dp[i][k - 1]

        return dp[-1][-1]