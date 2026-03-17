import sys

n, k = map(int, sys.stdin.readline().split())
graph = [[float('inf')] * (n + 1) for _ in range(n + 1)]

for _ in range(k):
    u, v = map(int, sys.stdin.readline().split())
    graph[u][v] = 1

for k in range(1, n + 1):
    for u in range(1, n + 1):
        for v in range(1, n + 1):
            graph[u][v] = min(graph[u][v], graph[u][k] + graph[k][v])

s = int(sys.stdin.readline())
answer = []
for _ in range(s):
    u, v = map(int, sys.stdin.readline().split())

    if graph[u][v] != float('inf'):
        answer.append('-1')
    elif graph[v][u] != float('inf'):
        answer.append('1')
    else:
        answer.append('0')

print('\n'.join(answer))