class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        ans = 0
        target = word

        while True:
            if target in sequence:
                target = target + word
                ans += 1
            else:
                return ans
