import sys

n, m = map(int, sys.stdin.readline().split())
graph = [[float('inf')] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u][v] = 1

for i in range(n + 1):
    graph[i][i] = 0

for k in range(1, n + 1):
    for u in range(1, n + 1):
        for v in range(1, n + 1):
            graph[u][v] = min(graph[u][v], graph[u][k] + graph[k][v])

ans = 0
for i in range(1, n + 1):
    flag = True

    for k in range(1, n + 1):
        if graph[i][k] == float('inf') and graph[k][i] == float('inf'):
            flag = False
            break

    if flag:
        ans += 1

print(ans)