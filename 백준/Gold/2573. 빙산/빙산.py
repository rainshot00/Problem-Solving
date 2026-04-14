import sys
from collections import deque


def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = True

    while q:
        y, x = q.popleft()

        for step in range(4):
            yy, xx = y + dy[step], x + dx[step]

            if arr[yy][xx] != 0 and not visited[yy][xx]:
                visited[yy][xx] = True
                q.append((yy, xx))


n, m = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dy = [1, 0, 0, -1]
dx = [0, 1, -1, 0]

year = 1
while True:
    meltarr = [[0] * m for _ in range(n)]
    for i in range(1, n - 1):
        for k in range(1, m - 1):
            if arr[i][k] != 0:
                melt = 0

                for step in range(4):
                    y, x = i + dy[step], k + dx[step]

                    if arr[y][x] == 0:
                        melt += 1

                meltarr[i][k] = melt

    for i in range(1, n - 1):
        for k in range(1, m - 1):
            arr[i][k] = max(arr[i][k] - meltarr[i][k], 0)

    visited = [[False] * m for _ in range(n)]
    check = 0
    for i in range(1, n - 1):
        for k in range(1, m - 1):
            if arr[i][k] != 0 and not visited[i][k]:
                if check == 0:
                    bfs(i, k)
                    check += 1
                else:
                    print(year)
                    sys.exit(0)

    if check == 0:
        print(0)
        break

    year += 1