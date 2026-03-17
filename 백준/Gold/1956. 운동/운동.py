import sys

V, E = map(int, sys.stdin.readline().split())
graph = [[float('inf')] * (V + 1) for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u][v] = w

for k in range(1, V + 1):
    for u in range(1, V + 1):
        for v in range(1, V + 1):
            graph[u][v] = min(graph[u][v], graph[u][k] + graph[k][v])

ans = float('inf')
for i in range(1, V + 1):
    ans = min(ans, graph[i][i])

if ans == float('inf'):
    ans = -1

print(ans)