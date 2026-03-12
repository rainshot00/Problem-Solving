import sys
import heapq


def dijkstra_fox(start_vertex):
    distance = [float('inf') for _ in range(n + 1)]
    distance[start_vertex] = 0
    pq = [(0, start_vertex)]

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


def dijkstra_wolf(start_vertex):
    distance = [[float('inf')] * 2 for _ in range(n + 1)]
    distance[start_vertex][0] = 0
    pq = [(0, start_vertex, 0)]

    while pq:
        d, now, state = heapq.heappop(pq)

        if d > distance[now][state]:
            continue

        for v, weight in graph[now]:
            if state == 0:
                dist = d + (weight / 2)
            else:
                dist = d + (weight * 2)

            next_state = (state + 1) % 2

            if dist < distance[v][next_state]:
                distance[v][next_state] = dist
                heapq.heappush(pq, (dist, v, next_state))

    return distance


n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w * 2))
    graph[v].append((u, w * 2))

ans = 0
dist_fox = dijkstra_fox(1)
dist_wolf = dijkstra_wolf(1)

for i in range(1, n + 1):
    if dist_fox[i] < min(dist_wolf[i][0], dist_wolf[i][1]):
        ans += 1

print(ans)