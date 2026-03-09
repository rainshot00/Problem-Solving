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


t = int(input())
answer = []

for testcase in range(1, t + 1):
    n, m = map(int, input().split())
    parent = [i for i in range(n + 1)]
    rank = [0 for _ in range(n + 1)]

    for _ in range(m):
        a, b = map(int, input().split())
        union(parent, rank, a, b)

    ans = 0

    for i in range(1, n + 1):
        if parent[i] == i:
            ans += 1

    answer.append(f'#{testcase} {ans}\n')

print(''.join(answer))