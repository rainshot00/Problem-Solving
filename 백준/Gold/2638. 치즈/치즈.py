import sys
from collections import deque


def find_air():
    air = [[False] * m for _ in range(n)]
    air[0][0] = True

    q = deque()
    q.append((0, 0))

    while q:
        y, x = q.popleft()

        for step in range(4):
            yy, xx = y + dy[step], x + dx[step]

            if arr[yy][xx] == 0 and not air[yy][xx]:
                air[yy][xx] = True
                q.append((yy, xx))

    return air


n, m = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dy = [1, 0, 0, -1]
dx = [0, 1, -1, 0]

year = 1
while True:
    air = find_air()
    meltarr = [[False] * m for _ in range(n)]

    for i in range(1, n - 1):
        for k in range(1, m - 1):
            if arr[i][k] == 1:
                melt = 0
                for step in range(4):
                    yy, xx = i + dy[step], k + dx[step]

                    if air[yy][xx]:
                        melt += 1

                if melt >= 2:
                    meltarr[i][k] = True

    for i in range(1, n - 1):
        for k in range(1, m - 1):
            if meltarr[i][k]:
                arr[i][k] = 0

    cheese = False
    for i in range(1, n - 1):
        for k in range(1, m - 1):
            if arr[i][k] == 1:
                cheese = True
                break

    if not cheese:
        print(year)
        break

    year += 1