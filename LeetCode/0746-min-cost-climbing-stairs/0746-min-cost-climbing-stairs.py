class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        cost.append(0)
        dp = [987654321] * (len(cost) + 1)

        dp[0] = 0
        dp[1] = cost[0]

        for i in range(2, len(dp)):
            dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i - 1]
        
        return dp[-1]