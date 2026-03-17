import sys
import heapq


def dijkstra(st):
    pq = []
    distance = [float('inf')] * (n + 1)

    for v in st:
        distance[v] = 0
        pq.append((0, v))

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        for next, weight in graph[now]:
            dist = d + weight

            if dist < distance[next]:
                distance[next] = dist
                heapq.heappush(pq, (dist, next))

    return distance


n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))
    graph[v].append((u, w))

p, q = map(int, sys.stdin.readline().split())
home = sorted(list(map(int, sys.stdin.readline().split())))
conv = list(map(int, sys.stdin.readline().split()))

distance = dijkstra(conv)

min_dist, ans = float('inf'), 0
for h in home:
    if distance[h] < min_dist:
        min_dist = distance[h]
        ans = h

print(ans)