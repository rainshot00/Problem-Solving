import sys
import heapq


def dijkstra(st, distance, max_dist):
    pq = []

    for v in st:
        distance[v] = 0
        pq.append((0, v))

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        for next, weight in graph[now]:
            dist = d + weight

            if dist > max_dist:
                continue

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

m, x = map(int, sys.stdin.readline().split())
mcdonald = list(map(int, sys.stdin.readline().split()))
mc_distance = [float('inf')] * (V + 1)

s, y = map(int, sys.stdin.readline().split())
starbucks = list(map(int, sys.stdin.readline().split()))
sb_distance = [float('inf')] * (V + 1)

mc_distance = dijkstra(mcdonald, mc_distance, x)
sb_distance = dijkstra(starbucks, sb_distance, y)

ans = float('inf')
for i in range(1, V + 1):
    if mc_distance[i] == 0 or sb_distance[i] == 0:
        continue

    ans = min(ans, mc_distance[i] + sb_distance[i])

if ans == float('inf'):
    ans = -1

print(ans)