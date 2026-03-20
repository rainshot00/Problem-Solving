import sys
import heapq


def dijkstra(point):
    distance = [float('inf')] * (V + 1)
    distance[point] = 0
    pq = [(0, point)]

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


V, E = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))
    graph[v].append((u, w))

st, ed = map(int, sys.stdin.readline().split())
p = int(sys.stdin.readline())
mid = list(map(int, sys.stdin.readline().split()))

distance_st = dijkstra(st)
distance_ed = dijkstra(ed)

ans = float('inf')
for v in mid:
    ans = min(ans, distance_st[v] + distance_ed[v])

if ans == float('inf'):
    print(-1)
else:
    print(ans)