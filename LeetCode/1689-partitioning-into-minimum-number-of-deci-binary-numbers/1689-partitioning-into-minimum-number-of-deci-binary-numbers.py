class Solution:
    def minPartitions(self, n: str) -> int:
        ans = -1

        for digit in n:
            ans = max(ans, int(digit))
        
        return ans