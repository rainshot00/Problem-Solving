class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        dict = {}
        idx = 0

        for num in nums:
            dict[num] = True
        
        for key in dict.keys():
            nums[idx] = key
            idx += 1
        
        return idx