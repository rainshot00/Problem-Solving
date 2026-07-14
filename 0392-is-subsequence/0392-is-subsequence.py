class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i, k = 0, 0

        while i < len(s) and k < len(t):
            if s[i] == t[k]:
                i += 1
            k += 1
        
        if i == len(s):
            return True
        else:
            return False