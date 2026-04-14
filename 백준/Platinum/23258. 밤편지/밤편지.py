import sys

n, q = map(int, sys.stdin.readline().split())
distance = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

for u in range(n):
    for v in range(n):
        if u == v:
            continue

        if distance[u][v] == 0:
            distance[u][v] = float('inf')

answer = [-1] * q
query = []

for i in range(q):
    c, u, v = map(int, sys.stdin.readline().split())
    query.append((c, u - 1, v - 1, i))

query.sort(key=lambda x: x[0])

now_k = 0
for c, u, v, index in query:
    for k in range(now_k, c - 1):
        for i in range(n):
            for j in range(n):
                distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])

    answer[index] = distance[u][v] if distance[u][v] != float('inf') else -1

    now_k = c - 1

for ans in answer:
    print(ans)