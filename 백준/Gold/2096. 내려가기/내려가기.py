import sys

n = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
min_ans, max_ans = float('inf'), -float('inf')

max_dp, min_dp = arr[0], arr[0]

for i in range(1, n):
    new_max_dp = [
        max(max_dp[0], max_dp[1]) + arr[i][0],
        max(max_dp[0], max(max_dp[1], max_dp[2])) + arr[i][1],
        max(max_dp[1], max_dp[2]) + arr[i][2]
    ]

    new_min_dp = [
        min(min_dp[0], min_dp[1]) + arr[i][0],
        min(min_dp[0], min(min_dp[1], min_dp[2])) + arr[i][1],
        min(min_dp[1], min_dp[2]) + arr[i][2]
    ]

    max_dp, min_dp = new_max_dp, new_min_dp

print(max(max_dp), min(min_dp))