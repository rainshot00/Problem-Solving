import sys
import heapq


def dijkstra(st, ed, not_visited = None):
    distance = [float('inf') for _ in range(n + 1)]
    distance[st] = 0
    pq = [(0, st)]

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        if now == ed:
            return distance[ed]

        for v, w in graph[now]:
            if v == not_visited:
                continue

            dist = d + w

            if dist < distance[v]:
                distance[v] = dist
                heapq.heappush(pq, (dist, v))

    return -1


n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append([v, w])

x, y, z = map(int, sys.stdin.readline().split())

xy, yz = dijkstra(x, y), dijkstra(y, z)

if xy == -1 or yz == -1:
    xyz = -1
else:
    xyz = xy + yz

xnotyz = dijkstra(x, z, y)

print(xyz, xnotyz)