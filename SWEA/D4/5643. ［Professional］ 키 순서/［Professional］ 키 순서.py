def floyd_warshall():
    distance = [[float('inf')] * (n + 1) for _ in range(n + 1)]

    for u in range(1, n + 1):
        distance[u][u] = 0

    for u in range(1, n + 1):
        for v in arr[u]:
            distance[u][v] = 1

    for k in range(1, n + 1):
        for u in range(1, n + 1):
            for v in range(1, n + 1):
                distance[u][v] = min(distance[u][v], distance[u][k] + distance[k][v])

    return distance


t = int(input())
answer = []

for testcase in range(1, t + 1):
    n = int(input())
    m = int(input())
    arr = [[] for _ in range(n + 1)]

    for _ in range(m):
        u, v = map(int, input().split())
        arr[u].append(v)

    distance = floyd_warshall()

    res = 0
    for i in range(1, n + 1):
        can_reach = True

        for k in range(1, n + 1):
            if distance[i][k] == float('inf') and distance[k][i] == float('inf'):
                can_reach = False
                break

        if can_reach:
            res += 1

    answer.append(f'#{testcase} {res}')

print('\n'.join(answer))