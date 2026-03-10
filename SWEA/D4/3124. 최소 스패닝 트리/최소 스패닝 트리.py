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
    V, E = map(int, input().split())
    edge = [list(map(int, input().split())) for _ in range(E)]
    parent = [i for i in range(V + 1)]
    rank = [0] * (V + 1)

    answer.append(f'#{testcase} {kruskal(edge)}\n')

print(''.join(answer))