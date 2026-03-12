import sys
import heapq


def dijkstra(y, x):
    distance = [[float('inf')] * n for _ in range(n)]
    distance[y][x] = arr[y][x]
    pq = [(distance[y][x], y, x)]

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


dy = [1, 0, 0, -1]
dx = [0, 1, -1, 0]
answer = []
testcase = 1

while True:
    n = int(sys.stdin.readline())

    if n == 0:
        break

    arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

    answer.append(f'Problem {testcase}: {dijkstra(0, 0)}')
    testcase += 1

print('\n'.join(answer))