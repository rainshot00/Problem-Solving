class Solution:
    def countBits(self, n: int) -> List[int]:
        ans = []

        for i in range(n + 1):
            now = i
            cnt = 0

            while now:
                if now % 2:
                    cnt += 1
                
                now //= 2
            
            ans.append(cnt)
        
        return ans