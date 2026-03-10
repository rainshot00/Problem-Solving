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
        if find(u) != find(v):
            union(u, v)
            cnt += 1
            weight += w

            if cnt == (n * m - 1):
                return weight


n, m = map(int, sys.stdin.readline().split())
edge = []
parent = [i for i in range(n * m)]
rank = [0] * (n * m)

for i in range(n):
    arr = list(map(int, sys.stdin.readline().split()))

    for k in range(len(arr)):
        u, v = i * m + k, i * m + (k + 1)
        edge.append([u, v, arr[k]])

for i in range(n - 1):
    arr = list(map(int, sys.stdin.readline().split()))

    for k in range(len(arr)):
        u, v = i * m + k, (i + 1) * m + k
        edge.append([u, v, arr[k]])

print(kruskal(edge))