class Solution:
    def canJump(self, nums: List[int]) -> bool:
        idx = 0

        for i in range(len(nums)):
            if i > idx:
                return False
            
            idx = max(idx, i + nums[i])

        return True