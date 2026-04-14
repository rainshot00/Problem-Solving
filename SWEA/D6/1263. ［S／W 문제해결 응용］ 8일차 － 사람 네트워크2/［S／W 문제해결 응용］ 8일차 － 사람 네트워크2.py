def floyd_warshall():
    distance = [[float('inf')] * n for _ in range(n)]

    for u in range(n):
        distance[u][u] = 0

    for u in range(n):
        for v in arr[u]:
            distance[u][v] = 1
            distance[v][u] = 1

    for k in range(n):
        for u in range(n):
            for v in range(n):
                distance[u][v] = min(distance[u][v], distance[u][k] + distance[k][v])

    return distance


t = int(input())
answer = []

for testcase in range (1, t + 1):
    str = list(map(int, input().split()))
    n = str[0]
    arr = [[] for _ in range(n)]

    for i in range(n):
        for k in range(n):
            if str[i * n + k + 1] == 1:
                arr[i].append(k)

    distance = floyd_warshall()

    res = float('inf')
    for i in range(n):
        res = min(res, sum(distance[i]))

    answer.append(f'#{testcase} {res}')

print('\n'.join(answer))