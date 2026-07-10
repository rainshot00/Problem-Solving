class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        ans = 0
        tmp = 0

        for num in nums:
            if num == 1:
                tmp += 1
                ans = max(ans, tmp)
            else:
                tmp = 0
        
        return ans