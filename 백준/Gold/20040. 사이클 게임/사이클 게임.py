import sys


def find(parent, x):
    if parent[x] == x:
        return x

    parent[x] = find(parent, parent[x])
    return parent[x]


def union(parent, rank, x, y):
    xx = find(parent, x)
    yy = find(parent, y)

    if xx == yy:
        return

    if rank[xx] < rank[yy]:
        xx, yy = yy, xx

    parent[yy] = xx

    if rank[xx] == rank[yy]:
        rank[xx] += 1


n, m = map(int, sys.stdin.readline().split())
parent = [i for i in range(n + 1)]
rank = [0] * (n + 1)

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())

    if find(parent, a) == find(parent, b):
        print(i + 1)
        sys.exit(0)

    union(parent, rank, a, b)

print(0)