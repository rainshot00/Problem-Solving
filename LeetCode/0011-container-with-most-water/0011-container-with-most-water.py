class Solution:
    def maxArea(self, height: List[int]) -> int:
        st, ed = 0, len(height) - 1
        ans = -1

        while st < ed:
            min_height = min(height[st], height[ed])
            ans = max(ans, min_height * (ed - st))

            if min_height == height[st]:
                st += 1
            else:
                ed -= 1
        
        return ans