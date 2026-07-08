class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        st, ed = 0, len(nums)

        while st < ed:
            mid = (st + ed) // 2

            if nums[mid] >= target:
                ed = mid
            else:
                st = mid + 1
        
        return st