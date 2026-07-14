class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        def check(string):
            if len(string) <= 1:
                return True
            
            if string[0] == string[-1]:
                return check(string[1 : -1])
            
            else:
                return False

        for length in range(len(s), 0, -1):
            for st in range(len(s) - length + 1):
                substr = s[st : st + length]
                
                if check(substr):
                    return substr