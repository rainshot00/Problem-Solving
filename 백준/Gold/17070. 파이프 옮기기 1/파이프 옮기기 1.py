import sys

n = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = 0

dp = [[[0, 0, 0] for _ in range(n)] for _ in range(n)]
for x in range(1, n):
    if arr[0][x] == 1:
        break

    dp[0][x][0] = 1

for i in range(1, n):
    for k in range(1, n):
        if arr[i][k] == 1:
            continue

        if arr[i][k - 1] == 0:
            dp[i][k][0] = dp[i][k - 1][0] + dp[i][k - 1][1]

        if arr[i - 1][k - 1] == 0 and arr[i - 1][k] == 0 and arr[i][k - 1] == 0:
            dp[i][k][1] = sum(dp[i - 1][k - 1])

        if arr[i - 1][k] == 0:
            dp[i][k][2] = dp[i - 1][k][1] + dp[i - 1][k][2]

print(sum(dp[n - 1][n - 1]))