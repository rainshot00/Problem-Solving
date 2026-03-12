import sys
import heapq
import copy


def dijkstra(start_vertex, end_vertex):
    distance = [[float('inf'), []] for _ in range(n + 1)]
    distance[start_vertex][0] = 0
    distance[start_vertex][1].append(start_vertex)
    pq = [(0, start_vertex)]

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now][0]:
            continue

        if now == end_vertex:
            return distance[end_vertex][0], distance[end_vertex][1]

        for v, weight, in graph[now]:
            dist = d + weight

            if dist < distance[v][0]:
                distance[v][0] = dist
                distance[v][1] = copy.deepcopy(distance[now][1])
                distance[v][1].append(v)

                heapq.heappush(pq, (dist, v))

    return distance[end_vertex][0], distance[end_vertex][1]


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))

st, ed = map(int, sys.stdin.readline().split())
dist, path = dijkstra(st, ed)

print(dist)
print(len(path))
print(' '.join(map(str, path)))