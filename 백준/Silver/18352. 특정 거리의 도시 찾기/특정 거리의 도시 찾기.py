import sys
import heapq


def dijkstra(st):
    distance = [float('inf')] * (n + 1)
    distance[st] = 0
    pq = [(0, st)]

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        for next in graph[now]:
            dist = d + 1

            if dist < distance[next]:
                distance[next] = dist
                heapq.heappush(pq, (dist, next))

    return distance

n, m, k, x = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)

distance = dijkstra(x)

answer = []
for idx, dist in enumerate(distance):
    if dist == k:
        answer.append(str(idx))

if len(answer) == 0:
    print(-1)
else:
    print('\n'.join(answer))
