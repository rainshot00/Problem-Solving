class Solution:
    def generateParenthesis(self, n: int) -> List[str]:

        def make(st, ed, string):
            if st == 0 and ed == 0:
                ans.append(string)
                return
            
            if st > 0:
                make(st - 1, ed, string + '(')
            if ed > 0 and st < ed:
                make(st, ed - 1, string + ')')
        
        ans = []

        make(n, n, '')

        return ans