import sys
import heapq


def prime():
    prime = [True] * 100_001
    prime[0], prime[1] = False, False

    for i in range(2, 100_000):
        if prime[i]:
            k = 2
            while i * k <= 100_000:
                prime[i * k] = False
                k += 1

    return prime


def dijkstra(st, ed):
    distance = [float('inf')] * (n + 2)
    distance[st] = 0
    pq = [(0, st)]

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        if now == ed:
            return distance[ed]

        for next, weight in graph[now]:
            dist = d + weight

            if dist < distance[next]:
                distance[next] = dist
                heapq.heappush(pq, (dist, next))

    return distance[ed]


a, b, c, d = map(int, sys.stdin.readline().split())
n = int(sys.stdin.readline())
pos = [(a, b), (c, d)]
graph = [[] for _ in range(n + 2)]

for _ in range(n):
    x, y = map(int, sys.stdin.readline().split())
    pos.append((x, y))

prime = prime()

for i in range(n + 2):
    for k in range(n + 2):
        if i == k:
            continue

        x1, y1 = pos[i][0], pos[i][1]
        x2, y2 = pos[k][0], pos[k][1]
        dist = int(((x1 - x2) ** 2 + (y1 - y2) ** 2) ** 0.5)

        if prime[dist]:
            graph[i].append((k, dist))

ans = dijkstra(0, 1)

if ans == float('inf'):
    print(-1)
else:
    print(ans)