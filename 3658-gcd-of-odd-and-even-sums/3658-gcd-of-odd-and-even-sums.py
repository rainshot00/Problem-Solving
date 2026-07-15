class Solution:
    def gcdOfOddEvenSums(self, n: int) -> int:
        
        def gcd(a, b):
            if b == 0:
                return a
            
            return gcd(b, a % b)
        
        sum_odd, sum_even = n ** 2, n ** 2 + n

        return gcd(sum_odd, sum_even)