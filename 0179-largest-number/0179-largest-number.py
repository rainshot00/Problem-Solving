class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        nums = list(map(str, nums))

        for i in range(len(nums)):
            for k in range(i + 1, len(nums)):
                if nums[i] + nums[k] < nums[k] + nums[i]:
                    nums[i], nums[k] = nums[k], nums[i]

        for num in nums:
            if num != '0':
                return ''.join(nums)
        
        return '0'