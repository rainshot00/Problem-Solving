import sys


def bellman_ford():
    for i in range(V):
        for now, next, w in edge:
            if distance[now] + w < distance[next]:
                distance[next] = distance[now] + w

                if i == V - 1:
                    return True

    return False


t = int(sys.stdin.readline())

for _ in range(t):
    V, E, W = map(int, sys.stdin.readline().split())
    edge = []
    distance = [0] * (V + 1)

    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().split())
        edge.append((u, v, w))
        edge.append((v, u, w))

    for _ in range(W):
        u, v, w = map(int, sys.stdin.readline().split())
        edge.append((u, v, -w))

    nc = bellman_ford()

    if nc:
        print('YES')
    else:
        print('NO')