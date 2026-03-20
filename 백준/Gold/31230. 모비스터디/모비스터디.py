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


V, E, st, ed = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))
    graph[v].append((u, w))

distance_st = dijkstra(st)
distance_ed = dijkstra(ed)
distance = distance_st[ed]

res = 0
answer = []
for v in range(1, V + 1):
    if distance == distance_st[v] + distance_ed[v]:
        res += 1
        answer.append(str(v))

print(res)
print(' '.join(answer))