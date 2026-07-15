class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [[float('inf')] * n for _ in range(n)]
        dp[0][0] = triangle[0][0]

        for i in range(1, n):
            for k in range(i + 1):
                dp[i][k] = min(dp[i - 1][k - 1], dp[i - 1][k]) + triangle[i][k]

        return min(dp[-1])