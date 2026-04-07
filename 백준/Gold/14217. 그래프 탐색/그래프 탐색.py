import sys
from collections import deque


def bfs():
    distance = [-1] * (n + 1)
    distance[1] = 0

    q = deque()
    q.append((1, 0))

    while q:
        now, d = q.popleft()

        for next in edge[now]:
            if distance[next] == -1:
                distance[next] = d + 1
                q.append((next, d + 1))

    return distance


n, m = map(int, sys.stdin.readline().split())
edge = [set() for _ in range(n + 1)]
answer = []

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    edge[u].add(v)
    edge[v].add(u)

q = int(sys.stdin.readline())

for _ in range(q):
    a, u, v = map(int, sys.stdin.readline().split())

    if a == 1:
        edge[u].add(v)
        edge[v].add(u)
    else:
        edge[u].discard(v)
        edge[v].discard(u)

    answer.append(bfs()[1:])

for ans in answer:
    for a in ans:
        print(a, end=' ')
    print()