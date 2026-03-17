import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
graph = [[float('inf')] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u][v] = min(graph[u][v], w)

for i in range(n + 1):
    graph[i][i] = 0

for k in range(1, n + 1):
    for u in range(1, n + 1):
        for v in range(1, n + 1):
            graph[u][v] = min(graph[u][v], graph[u][k] + graph[k][v])

for i in range(1, n + 1):
    for k in range(1, n + 1):
        if graph[i][k] == float('inf'):
            print(0, end=' ')
        else:
            print(graph[i][k], end=' ')
    print()