import sys
import heapq


def dijkstra(st, ed):
    weight = [0] * (n + 1)
    weight[st] = 0
    pq = [(-float('inf'), st)]

    while pq:
        w, now = heapq.heappop(pq)
        w = -w

        if w < weight[now]:
            continue

        if now == ed:
            return weight[ed]

        for next, ww in graph[now]:
            max_weight = min(w, ww)

            if max_weight > weight[next]:
                weight[next] = max_weight
                heapq.heappush(pq, (-max_weight, next))

    return weight[ed]


n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))
    graph[v].append((u, w))

st, ed = map(int, sys.stdin.readline().split())

print(dijkstra(st, ed))