import sys
sys.setrecursionlimit(500**2)


def dfs(y, x):
    if not (0 <= y < n and 0 <= x < m):
        return 1

    if visited[y][x] != -1:
        if visited[y][x] == 2:
            return 0

        return visited[y][x]

    visited[y][x] = 2

    if arr[y][x] == 'U':
        yy, xx = y - 1, x
    elif arr[y][x] == 'D':
        yy, xx = y + 1, x
    elif arr[y][x] == 'L':
        yy, xx = y, x - 1
    else:
        yy, xx = y, x + 1

    visited[y][x] = dfs(yy, xx)

    return visited[y][x]


n, m = map(int, sys.stdin.readline().split())
arr = [list(sys.stdin.readline().strip()) for _ in range(n)]
visited = [[-1] * m for _ in range(n)]
ans = 0

for i in range(n):
    for k in range(m):
        if dfs(i, k) == 1:
            ans += 1

print(ans)