class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()

        ans = float('inf')

        for i in range(len(nums) - 2):
            left = i + 1
            right = len(nums) - 1

            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                
                if abs(ans - target) > abs(sum - target):
                    ans = sum
                
                if sum > target:
                    right -= 1
                elif sum < target:
                    left += 1
                else:
                    return ans
        
        return ans