import sys
import heapq

t = int(sys.stdin.readline())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    graph = [[float('inf')] * (n + 1) for _ in range(n + 1)]

    for _ in range(m):
        u, v, w = map(int, sys.stdin.readline().split())
        graph[u][v] = w
        graph[v][u] = w

    for i in range(n + 1):
        graph[i][i] = 0

    f = int(sys.stdin.readline())
    friend = list(map(int, sys.stdin.readline().split()))

    for k in range(1, n + 1):
        for u in range(1, n + 1):
            for v in range(1, n + 1):
                graph[u][v] = min(graph[u][v], graph[u][k] + graph[k][v])

    min_sum = float('inf')
    ans = -1
    for room in range(1, n + 1):
        sum = 0

        for f in friend:
            sum += graph[room][f]

        if sum < min_sum:
            min_sum = sum
            ans = room

    print(ans)