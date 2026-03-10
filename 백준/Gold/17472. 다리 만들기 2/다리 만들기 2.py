import sys
from collections import deque


def bfs(y, x, num):
    q = deque()
    q.append([y, x])
    arr[y][x] = num
    visited[y][x] = True

    while q:
        y, x = q.popleft()

        for step in range(4):
            yy = y + dy[step]
            xx = x + dx[step]

            if 0 <= yy < n and 0 <= xx < m and not visited[yy][xx] and arr[yy][xx] == 1:
                visited[yy][xx] = True
                arr[yy][xx] = num
                q.append([yy, xx])


def findEdge(y, x, step):
    start = arr[y][x]
    len = 0

    yy = y + dy[step]
    xx = x + dx[step]

    while 0 <= yy < n and 0 <= xx < m:
        if arr[yy][xx] == 0:
            len += 1
            yy += dy[step]
            xx += dx[step]

        elif arr[yy][xx] == start:
            break

        else:
            if len >= 2:
                end = arr[yy][xx]
                edge.append([start, end, len])
            break


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])

    return parent[x]


def union(x, y):
    xx = find(x)
    yy = find(y)

    if xx == yy:
        return

    if rank[xx] < rank[yy]:
        xx, yy = yy, xx

    parent[yy] = xx

    if rank[xx] == rank[yy]:
        rank[xx] += 1


def kruskal():
    cnt, weight = 0, 0

    for u, v, w in edge:
        if find(u) != find(v):
            union(u, v)
            cnt += 1
            weight += w

    if cnt == (numIsland - 1):
        return weight
    else:
        return -1


n, m = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
edge = []

dy = [1, 0, 0, -1]
dx = [0, 1, -1, 0]

# 0. bfs로 섬 구역 결정하고
# 1. 한 섬에서 다른 섬까지의 최소 거리 구하고
# 2. kruskal로 연결
# 3. kruskal에서 마지막에 root 수가 2 이상이면 return -1

numIsland = 1
for i in range(n):
    for k in range(m):
        if arr[i][k] == 1 and not visited[i][k]:
            bfs(i, k, numIsland)
            numIsland += 1

numIsland -= 1

for i in range(n):
    for k in range(m):
        if arr[i][k] != 0:
            for step in range(4):
                findEdge(i, k, step)

edge.sort(key=lambda x: x[2])
parent = [i for i in range(numIsland + 1)]
rank = [0] * (numIsland + 1)
print(kruskal())