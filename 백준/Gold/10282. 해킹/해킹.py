import sys
import heapq


def dijkstra(st):
    distance = [float('inf')] * (V + 1)
    distance[st] = 0
    pq = [(0, st)]

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


t = int(sys.stdin.readline())

for _ in range(t):
    V, E, c = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(V + 1)]

    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().split())
        graph[v].append((u, w))

    distance = dijkstra(c)

    cnt, time = 0, 0
    for d in distance:
        if d != float('inf'):
            cnt += 1
            time = max(time, d)

    print(cnt, time)