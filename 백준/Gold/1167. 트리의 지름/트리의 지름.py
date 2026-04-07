import sys
from collections import deque


def bfs(st):
    distance = [-1] * (n + 1)
    distance[st] = 0

    q = deque()
    q.append((st, 0))

    while q:
        now, d = q.popleft()

        for next, dist in edge[now]:
            if distance[next] == -1:
                distance[next] = d + dist
                q.append((next, d + dist))

    max_dist_vertex = -1
    max_dist = -1

    for i in range(1, n + 1):
        if distance[i] > max_dist:
            max_dist = distance[i]
            max_dist_vertex = i

    return max_dist_vertex, max_dist


n = int(sys.stdin.readline())
edge = [[] for _ in range(n + 1)]

for _ in range(n):
    arr = list(map(int, sys.stdin.readline().split()))
    now = arr[0]

    for i in range(1, len(arr) - 1, 2):
        next, dist = arr[i], arr[i + 1]
        edge[now].append((next, dist))

start, _ = bfs(1)
_, answer = bfs(start)

print(answer)