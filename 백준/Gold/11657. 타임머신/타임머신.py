import sys


def bellman_ford(st):
    distance[st] = 0

    for i in range(n):
        for k in range(m):
            now, next, w = edge[k]

            if distance[now] != float('inf') and distance[next] > distance[now] + w:
                distance[next] = distance[now] + w

                if i == n - 1:
                    return True

    return False


n, m = map(int, sys.stdin.readline().split())
edge = []
distance = [float('inf')] * (n + 1)

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    edge.append((u, v, w))


nc = bellman_ford(1)

if not nc:
    for i in range(2, n + 1):
        if distance[i] == float('inf'):
            print(-1)
        else:
            print(distance[i])

else:
    print(-1)