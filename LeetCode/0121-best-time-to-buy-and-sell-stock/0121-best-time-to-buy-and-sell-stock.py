class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        min_price = 987654321

        for i in range(1, len(prices) + 1):
            min_price = min(min_price, prices[i - 1])
            
            ans = max(ans, prices[i - 1] - min_price)

        return ans