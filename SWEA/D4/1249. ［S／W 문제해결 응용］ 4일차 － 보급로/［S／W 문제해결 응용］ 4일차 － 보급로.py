import heapq


def dijkstra():
    distance = [[float('inf')] * n for _ in range(n)]
    distance[0][0] = 0
    pq = [(0, 0, 0)]

    while pq:
        d, y, x = heapq.heappop(pq)

        if d > distance[y][x]:
            continue

        for step in range(4):
            yy = y + dy[step]
            xx = x + dx[step]

            if 0 <= yy < n and 0 <= xx < n:
                dist = d + arr[yy][xx]

                if dist < distance[yy][xx]:
                    distance[yy][xx] = dist
                    heapq.heappush(pq, (dist, yy, xx))

    return distance[n - 1][n - 1]


t = int(input())
dy = [1, 0, 0, -1]
dx = [0, 1, -1, 0]
answer = []

for testcase in range(1, t + 1):
    n = int(input())
    arr = [list(map(int, input())) for _ in range(n)]

    answer.append(f'#{testcase} {dijkstra()}')

print('\n'.join(answer))