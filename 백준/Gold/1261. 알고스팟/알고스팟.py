import sys
from collections import deque


def bfs_01():
    dq = deque()
    distance = [[float('inf')] * m  for _ in range(n)]
    distance[0][0] = 0
    dq.append((0, 0))

    while dq:
        y, x = dq.popleft()
        d = distance[y][x]

        if y == n - 1 and x == m - 1:
            return distance[y][x]

        for step in range(4):
            yy = y + dy[step]
            xx = x + dx[step]

            if 0 <= yy < n and 0 <= xx < m:
                dist = d + graph[yy][xx]

                if dist < distance[yy][xx]:
                    distance[yy][xx] = dist

                    if graph[yy][xx] == 0:
                        dq.appendleft((yy, xx))
                    else:
                        dq.append((yy, xx))

    return -1


m, n = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
dy = [1, 0, 0, -1]
dx = [0, 1, -1, 0]

print(bfs_01())