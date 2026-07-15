class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[0] * n for _ in range(m)]

        for i in range(m):
            if obstacleGrid[i][0] == 1:
                break
            
            dp[i][0] = 1
        
        for k in range(n):
            if obstacleGrid[0][k] == 1:
                break
            
            dp[0][k] = 1
        
        for i in range(1, m):
            for k in range(1, n):
                if obstacleGrid[i][k] == 1:
                    continue
                    
                dp[i][k] = dp[i - 1][k] + dp[i][k - 1]

        return dp[-1][-1]