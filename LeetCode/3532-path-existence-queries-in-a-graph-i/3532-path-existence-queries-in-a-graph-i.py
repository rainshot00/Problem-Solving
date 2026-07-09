class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
        ans, group = [], [0] * n
        g = 0

        for i in range(1, len(nums)):
            if nums[i] - nums[i - 1] > maxDiff:
                g += 1
            
            group[i] = g
        
        for query in queries:
            st, ed = query

            if group[st] == group[ed]:
                ans.append(True)
            else:
                ans.append(False)

        return ans