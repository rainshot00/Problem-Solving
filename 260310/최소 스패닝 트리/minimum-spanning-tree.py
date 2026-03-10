import sys


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])

    return parent[x]


def union(x, y):
    xx = find(x)
    yy = find(y)

    if xx == yy:
        return

    if rank[xx] < rank[yy]:
        xx, yy = yy, xx

    parent[yy] = xx

    if rank[xx] == rank[yy]:
        rank[xx] += 1


def kruskal(n, edge):
    cnt, weight = 0, 0
    edge.sort(key=lambda x: x[2])

    for e in edge:
        u, v, w = e
        if find(u) != find(v):
            union(u, v)
            cnt += 1
            weight += w

            if cnt == (n - 1):
                return cnt, weight


n, m = map(int, sys.stdin.readline().split())
edge = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
parent = [i for i in range(n + 1)]
rank = [0] * (n + 1)

_, weight = kruskal(n, edge)
print(weight)