import sys

# gcd(1이 a개, 1이 b개) = 1이 gcd(a, b)개
def gcd(a, b):
    while b > 0:
        a, b = b, a % b

    return a


a, b = map(int, sys.stdin.readline().split())

ans = gcd(a, b)

print('1' * ans)