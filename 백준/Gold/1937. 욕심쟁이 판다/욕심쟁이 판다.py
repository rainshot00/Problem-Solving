import sys
sys.setrecursionlimit(500**2)


def dfs(y, x):
    if dp[y][x] != 1:
        return dp[y][x]

    for step in range(4):
        yy, xx = y + dy[step], x + dx[step]

        if 0 <= yy < n and 0 <= xx < n and arr[yy][xx] > arr[y][x]:
            dp[y][x] = max(dp[y][x], dfs(yy, xx) + 1)

    return dp[y][x]


n = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dp = [[1] * n for _ in range(n)]
dy = [1, 0, 0, -1]
dx = [0, 1, -1, 0]

for i in range(n):
    for k in range(n):
        if dp[i][k] == 1:
            dfs(i, k)

print(max(map(max, dp)))