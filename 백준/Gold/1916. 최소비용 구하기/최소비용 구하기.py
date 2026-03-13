import sys
import heapq


def dijkstra():
    distance = [float('inf') for _ in range(n + 1)]
    pq = [(0, st)]

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        if now == ed:
            return distance[now]

        for v, w in edge[now]:
            dist = d + w

            if dist < distance[v]:
                distance[v] = dist
                heapq.heappush(pq, (dist, v))

    return -1


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
edge = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    edge[u].append((v, w))

st, ed = map(int, sys.stdin.readline().split())

print(dijkstra())