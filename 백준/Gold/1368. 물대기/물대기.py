import sys
import heapq

n = int(sys.stdin.readline())
vertex = list(int(sys.stdin.readline()) for _ in range(n))
edge = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
arr = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for i in range(n):
    arr[0].append((i + 1, vertex[i]))
    arr[i + 1].append((0, vertex[i]))

for i in range(n):
    for k in range(n):
        if i == k:
            continue

        arr[i + 1].append((k + 1, edge[i][k]))

for i in range(n):
    arr[i].append((i, vertex[i]))

pq = [(0, 0)]
cnt, weight = 0, 0

while pq:
    w, now = heapq.heappop(pq)

    if visited[now]:
        continue

    visited[now] = True
    weight += w
    cnt += 1

    if cnt == (n + 1):
        break

    for next_vertex, next_weight in arr[now]:
        if not visited[next_vertex]:
            heapq.heappush(pq, (next_weight, next_vertex))

print(weight)