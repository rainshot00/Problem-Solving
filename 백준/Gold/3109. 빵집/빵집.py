import sys
sys.setrecursionlimit(10 ** 4)


def dfs(y, x):
    if x == c - 1:
        return True

    for step in range(3):
        yy = y + dy[step]
        xx = x + dx[step]

        if 0 <= yy < r and 0 <= xx < c:
            if arr[yy][xx] == '.' and not visited[yy][xx]:
                visited[yy][xx] = True
                if dfs(yy, xx):
                    return True

    return False


r, c = map(int, sys.stdin.readline().split())
arr = [list(sys.stdin.readline().strip()) for _ in range(r)]
visited = [[False] * c for _ in range(r)]

dy = [-1, 0, 1]
dx = [1, 1, 1]
ans = 0

for y in range(r):
    if arr[y][0] == '.':
        if dfs(y, 0):
            ans += 1

print(ans)