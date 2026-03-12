import sys
import heapq


def dijkstra(graph, start_vertex, end_vertex):
    distance = [float('inf') for _ in range(n + 1)]
    distance[start_vertex] = 0
    pq = [(0, start_vertex)]

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        for v, weight, in graph[now]:
            dist = d + weight

            if dist < distance[v]:
                distance[v] = dist
                heapq.heappush(pq, (dist, v))

    return distance[end_vertex]



n, m, x = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for i in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))

res = -1
for i in range(1, n + 1):
    res = max(res, dijkstra(graph, i, x) + dijkstra(graph, x, i))

print(res)