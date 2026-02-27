import sys
from collections import deque


def bfs():
    # y, x, cnt, can_break
    q = deque()
    q.append((0, 0, 1))
    visited[0][0][1] = 1

    while q:
        y, x, can_break = q.popleft()

        if y == (n - 1) and x == (m - 1):
            return min(visited[n - 1][m - 1][0], visited[n - 1][m - 1][1])

        for step in range(4):
            yy = y + dy[step]
            xx = x + dx[step]

            if yy < 0 or yy >= n or xx < 0 or xx >= m:
                continue

            if visited[yy][xx][can_break] != 987654321:
                continue

            if arr[yy][xx] == 1 and can_break:
                visited[yy][xx][0] = visited[y][x][1] + 1
                q.append((yy, xx, 0))

            if arr[yy][xx] == 0:
                visited[yy][xx][can_break] = visited[y][x][can_break] + 1
                q.append((yy, xx, can_break))

    return -1


n, m = map(int, sys.stdin.readline().split())

arr = []
visited = [[[987654321, 987654321] for _ in range(m)] for _ in range(n)]
dy = [1, 0, 0, -1]
dx = [0, 1, -1, 0]

for i in range(n):
    arr.append(list(map(int, sys.stdin.readline().strip())))

print(bfs())