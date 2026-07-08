from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        dq = deque()

        for br in s:
            if br == '(' or br == '{' or br == '[':
                dq.append(br)

            else:
                if len(dq) == 0:
                    return False
                
                last = dq.pop()

                if br == ')' and last != '(':
                    return False
                
                if br == '}' and last != '{':
                    return False
                
                if br == ']' and last != '[':
                    return False
                
        if len(dq) != 0:
            return False
        
        return True