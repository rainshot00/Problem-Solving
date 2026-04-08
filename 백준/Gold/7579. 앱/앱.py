import sys

n, m = map(int, sys.stdin.readline().split())
byte = list(map(int, sys.stdin.readline().split()))
cost = list(map(int, sys.stdin.readline().split()))

sum_cost = sum(cost)
# dp[i] = i의 cost를 지불했을 때 얻을 수 있는 최대 byte
dp = [0] * (sum_cost + 1)

for i in range(n):
    b, c = byte[i], cost[i]

    # range(c, sum_cost + 1)은 같은 아이템을 2번 이상 사용할 수 있음
    for k in range(sum_cost, c - 1, -1):
        dp[k] = max(dp[k], dp[k - c] + b)

for i in range(len(dp)):
    if dp[i] >= m:
        print(i)
        break