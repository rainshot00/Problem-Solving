t = int(input())
answer = []

for testcase in range(1, t + 1):
    n, k = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    ans = 0

    for y in range(n):
        flag = True
        visited = [False] * n

        for x in range(1, n):

            if abs(arr[y][x] - arr[y][x - 1]) > 1:
                flag = False
                break

            if arr[y][x] > arr[y][x - 1]:
                for i in range(1, k + 1):
                    if x - i < 0 or arr[y][x - 1] != arr[y][x - i] or visited[x - i]:
                        flag = False
                        break

                    visited[x - i] = True

            if arr[y][x] < arr[y][x - 1]:
                for i in range(k):
                    if x + i >= n or arr[y][x] != arr[y][x + i] or visited[x + i]:
                        flag = False
                        break

                    visited[x + i] = True

        if flag:
            ans += 1

    for x in range(n):
        flag = True
        visited = [False] * n

        for y in range(1, n):

            if abs(arr[y][x] - arr[y - 1][x]) > 1:
                flag = False
                break

            if arr[y][x] > arr[y - 1][x]:
                for i in range(1, k + 1):
                    if y - i < 0 or arr[y - 1][x] != arr[y - i][x] or visited[y - i]:
                        flag = False
                        break

                    visited[y - i] = True

            if arr[y][x] < arr[y - 1][x]:
                for i in range(k):
                    if y + i >= n or arr[y][x] != arr[y + i][x] or visited[y + i]:
                        flag = False
                        break

                    visited[y + i] = True

        if flag:
            ans += 1

    answer.append(f'#{testcase} {ans}\n')

print(''.join(answer))