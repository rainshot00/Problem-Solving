import sys
from collections import deque


def bfs_01():
    dq = deque()
    distance = [[float('inf')] * 2 for _ in range(n + 1)]

    for v, t in edge[st]:
        distance[v][t] = 0
        dq.append((v, t))

    while dq:
        now, t = dq.popleft()

        for v, tt in edge[now]:
            weight = 0 if t == tt else 1

            if distance[now][t] + weight < distance[v][tt]:
                distance[v][tt] = distance[now][t] + weight

                if weight == 0:
                    dq.appendleft((v, tt))
                else:
                    dq.append((v, tt))

    return min(distance[ed][0], distance[ed][1])


n, m = map(int, sys.stdin.readline().split())
edge = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, t = map(int, sys.stdin.readline().split())
    edge[u].append((v, t))
    edge[v].append((u, t))

st, ed = map(int, sys.stdin.readline().split())

print(bfs_01())