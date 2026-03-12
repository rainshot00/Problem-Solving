import sys
import heapq


def dijkstra(st):
    distance = [float('inf') for _ in range(V + 1)]
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


V, E = map(int, sys.stdin.readline().split())
st = int(sys.stdin.readline())
graph = [[] for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))

dist = dijkstra(st)[1:]

for d in dist:
    if d == float('inf'):
        print('INF')
    else:
        print(d)