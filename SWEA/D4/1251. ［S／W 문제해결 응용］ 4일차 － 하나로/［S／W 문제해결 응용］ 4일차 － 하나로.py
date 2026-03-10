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

            if cnt == (V - 1):
                return weight


t = int(input())
answer = []

for testcase in range(1, t + 1):
    V = int(input())
    X = list(map(int, input().split()))
    Y = list(map(int, input().split()))
    tax = float(input())
    edge = []

    parent = [i for i in range(V)]
    rank = [0] * V

    for i in range(V):
        for k in range(V):
            if i == k:
                continue

            weight = ((X[i] - X[k]) ** 2 + (Y[i] - Y[k]) ** 2)
            edge.append([i, k, weight])

    answer.append(f'#{testcase} {round(tax * kruskal(edge))}\n')

print(''.join(answer))