import sys
import heapq


def dijkstra(st):
    distance = [float('inf') for _ in range(n + 1)]
    distance[st] = 0
    pq = [(0, st)]

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        for v, weight in graph[now]:
            dist = d + weight

            if dist < distance[v]:
                distance[v] = dist
                heapq.heappush(pq, (dist, v))

    return distance


n = int(sys.stdin.readline())
friend = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
graph = [[] for _ in range(n + 1)]
dist = []

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))
    graph[v].append((u, w))

for pos in friend:
    dist.append(dijkstra(pos))

d = -1
ans = 0
for i in range(1, n + 1):
    min_dist = min(min(dist[0][i], dist[1][i]), dist[2][i])
    if min_dist > d:
        d = min_dist
        ans = i

print(ans)