from collections import defaultdict

class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        last_index = defaultdict(int)
        ans = []

        for i, c in enumerate(s):
            last_index[c] = i
        
        for i, c in enumerate(s):
            if c in ans:
                continue
            
            while ans and ans[-1] > c and last_index[ans[-1]] > i:
                ans.pop()
            
            ans.append(c)
        
        return ''.join(ans)