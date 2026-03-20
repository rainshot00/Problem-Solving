import sys


V, E, T = map(int, sys.stdin.readline().split())
graph = [[float('inf')] * (V + 1) for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u][v] = w

for k in range(1, V + 1):
    for u in range(1, V + 1):
        for v in range(1, V + 1):
            graph[u][v] = min(graph[u][v], max(graph[u][k], graph[k][v]))

answer = []
for _ in range(T):
    st, ed = map(int, sys.stdin.readline().split())
    answer.append(str(graph[st][ed]) if graph[st][ed] != float('inf') else '-1')

print('\n'.join(answer))