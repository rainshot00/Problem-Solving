import sys
from collections import deque


def bfs_01():
    dq = deque()
    distance = [[float('inf')] * w for _ in range(h)]
    distance[st_y][st_x] = 0
    dq.append((st_y, st_x))

    while dq:
        y, x = dq.popleft()

        if graph[y][x] == '*':
            return distance[y][x]

        for yy, xx, weight in edge[y][x]:
            dist = distance[y][x] + weight

            if dist < distance[yy][xx]:
                distance[yy][xx] = dist

                if weight == 0:
                    dq.appendleft((yy, xx))
                else:
                    dq.append((yy, xx))

    return -1


h, w = map(int, sys.stdin.readline().split())
graph = [list(sys.stdin.readline().strip()) for _ in range(h)]
edge = [[[] for _ in range(w)] for _ in range(h)]
dy = [1, 0, -1, 1, -1, 1, 0, -1]
dx = [1, 1, 1, 0, 0, -1, -1, -1]
st_y, st_x = 0, 0

for y in range(h):
    for x in range(w):
        if graph[y][x] == '#':
            continue

        if graph[y][x] == 'K':
            st_y, st_x = y, x

        for step in range(8):
            yy = y + dy[step]
            xx = x + dx[step]

            if 0 <= yy < h and 0 <= xx < w:
                if step < 3:
                    edge[y][x].append((yy, xx, 0))
                else:
                    edge[y][x].append((yy, xx, 1))

print(bfs_01())