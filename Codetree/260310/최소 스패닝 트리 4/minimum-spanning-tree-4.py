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


def kruskal(edge):
    cnt, weight = 0, 0
    edge.sort(key=lambda x: x[2])

    for u, v, w in edge:
        if find(u) != find(v) and vertex[u] != vertex[v]:
            union(u, v)
            cnt += 1
            weight += w

    root = set(find(i) for i in range(1, n + 1))
    if len(root) == 1:
        return weight
    else:
        return -1


n, m = map(int, sys.stdin.readline().split())
vertex = list(sys.stdin.readline().split())
vertex.insert(0, None)
edge = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
parent = [i for i in range(n + 1)]
rank = [0] * (n + 1)

print(kruskal(edge))