from collections import deque


def cnt(y, x, n, arr):
    res = 0

    for step in range(8):
        yy = y + dy[step]
        xx = x + dx[step]

        if 0 <= yy < n and 0 <= xx < n and arr[yy][xx] == '*':
            res += 1

    return res


def bfs(y, x, n, arr, visited):
    q = deque()
    q.append([y, x])
    visited[y][x] = True

    while q:
        y, x = q.popleft()

        if cnt(y, x, n, arr) == 0:
            for step in range(8):
                yy = y + dy[step]
                xx = x + dx[step]

                if 0 <= yy < n and 0 <= xx < n and arr[yy][xx] == '.' and not visited[yy][xx]:
                    visited[yy][xx] = True

                    if cnt(yy, xx, n, arr) == 0:
                        q.append([yy, xx])


t = int(input())
dy = [1, 1, 1, 0, 0, -1, -1, -1]
dx = [1, 0, -1, 1, -1, 1, 0, -1]
answer = []

for testcase in range(1, t + 1):
    n = int(input())
    arr = [list(input()) for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    ans = 0

    for i in range(n):
        for k in range(n):
            if arr[i][k] == '.' and not visited[i][k]:
                if cnt(i, k, n, arr) == 0:
                    bfs(i, k, n, arr, visited)
                    ans += 1

    for i in range(n):
        for k in range(n):
            if arr[i][k] == '.' and not visited[i][k]:
                ans += 1

    answer.append(f'#{testcase} {ans}\n')

print(''.join(answer))