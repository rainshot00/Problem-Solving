class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        ans = [1]

        for i in range(rowIndex):
            ans.append(0)

            for k in range(len(ans) - 1, 0, -1):
                ans[k] = ans[k] + ans[k - 1]
        
        return ans