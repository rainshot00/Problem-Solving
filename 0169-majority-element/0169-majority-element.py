class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        cnt = defaultdict(int)

        for num in nums:
            cnt[num] += 1
        
        for key, value in cnt.items():
            if value > len(nums) // 2:
                return key