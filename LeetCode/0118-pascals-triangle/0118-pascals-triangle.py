class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [[1]]

        for i in range(numRows - 1):
            tmp = []
            tmp.append(1)

            for k in range(i):
                tmp.append(ans[i][k] + ans[i][k + 1])
            
            tmp.append(1)
            ans.append(tmp)
        
        return ans
